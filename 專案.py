from vpython import *
import numpy as np
scene = canvas(center=vec(30,30,0), background=vec(1,1,1))
wall1= box(pos=vec(81,2,0), size=vec(1,5,53), color=vec(9,1,0))
wall2= box(pos=vec(-21,2,0), size=vec(1,5,53), color=vec(9,1,0))
wall3= box(pos=vec(30,2,-27), size=vec(103,5,1), color=vec(9,1,0))
wall4=box(pos=vec(30,2,27), size=vec(103,5,1), color=vector(9,1,0))
table = box(pos=vec(30,0,0), size=vec(100,0.25,53), color=vec(0,1,0))
ball1 = sphere(pos=vec(-5,1.1,1.5), radius=1, color=vec(9,1,7), v=vec(0,0,0))
pole0 = cylinder(pos=vec(-5,-1,1.5), axis=vec(0,4,0), radius=0.1, color=vec(0,0,0))
ball_1 = compound([ball1,pole0], make_trail=True)
ball2 = sphere(pos=vec(20,1,2.5), radius=1, color=vec(0,0,1), v=vec(0,0,0), make_trail=True)
pole1 = cylinder(pos=vec(-5,2,1.5), axis=vec(0,10,0), radius=0.1, color=vec(1,0,0))
pole2 = cylinder(pos=vec(-5,2,1.5), axis=vec(0,10,0), radius=0.1, color=vec(0,1,0))
pole1.rotate(angle=1,axis=vector(3,0,0))
pole2.rotate(angle=1,axis=vector(4,0,0))
#做完後加上判斷式
va=eval(input('enter pitch angle:  ')) #輸入degree
va=va*3.14/180 #換成radius
t = 0
dt = 0.1
m = 170

pole = cylinder(pos=vec(-40,1.2+10*np.sin(va),1.5), axis=vec(20,0,0),
                radius=0.5, color=vec(1,1,0))
pole.rotate(angle=va*57.3, axis=vec(-25,4.3,0))
print('Use right and left to control the bar.')

kt=0
while pole.pos.x < ball1.pos.x - 21: #拉桿動畫 力由拉的幅度決定 最大80
    rate(125)
    k=keysdown()
    label(pos=vector(-5,2,-20),text=('force:',kt))
    if 'right' in k:
        pole.pos+=vec(2*dt,0,0)
        kt+=2
    if 'left' in k:
        pole.pos+=vec(-2*dt,0,0)
        kt=0
F=kt

phi = (np.arctan((pole.pos.y-ball1.pos.y) / (pole.pos.x-ball1.pos.x+10**-10)))
theta = np.arctan(pole.pos.x/pole.pos.z)

if phi!=0: #垂直面速度
    ball1.v.y = F*sin(phi)*dt*0.8/m
else:
    ball1.v.y = 0

def bff_x(): #x分量摩擦力
    dxcf = 9.8*(dt**2)
    return dxcf

def bff_z(): #z分量摩擦力
    dxcf = 9.8*(dt**2)
    return dxcf

def cueball_to_ball(v1, v2, x1, x2): #母球對子球
    v1_prime = v1 + dot((v2 - v1), (x1 - x2)) / mag2(x1 - x2) * (x1 - x2)
    v2_prime = v2 + dot((v1 - v2), (x2 - x1)) / mag2(x2 - x1) * (x2 - x1)
    return (v1_prime, v2_prime)

def cueball_to_wall(pos,v): #球撞牆反彈
    r = 1
    if pos.z - r <= -26.5 or pos.z + r >= 26.5:
        v.z = -0.75*v.z
    if pos.x - r <= -20 or pos.x + r >= 80:
        v.x = -0.75*v.x 
    return (v)

ball1.v.x = F*(40)/m

while ball_1.pos.x < 80 and ball_1.pos.y > 0.85: #主程式
    t += dt
    rate(40)
    a1 = pole.pos.x*F/(0.4*m*1) #角速度
    a2 = pole.pos.y*F/(0.4*m*1) 
    ball1.v.y = ball1.v.y*dt-(0.098*(t))

    if ball_1.pos.y < 0.95: #母球y分量
        ball1.v.y = ball1.v.y*(-0.8)

    if ball1.v != vec(0,0,0): #當母球開始移動 xz分量受摩擦力變化
        if ball1.v.x > 1e-10:
            ball1.v.x = ball1.v.x-(bff_x())
        if ball1.v.z > 1e-10:
            ball1.v.z = ball1.v.z-(bff_z())
        ball_1.pos += ball1.v *dt #移動
        ball_1.rotate(angle=0.1, axis=vec(10*F*np.cos(phi)*np.cos(theta),
                      a1+a2,10*F*np.cos(phi)*np.sin(theta))) #轉動
        if ball1.v.x < 0.001 and ball1.v.z < 0.001: #球停止條件
            ball1.v = vec(0,0,0)
    cueball_to_wall(ball_1.pos,ball1.v) #判斷球有沒有撞牆


    if(mag(ball_1.pos - ball2.pos)) <= (ball1.radius + ball2.radius): #撞擊條件
       ball1.v, ball2.v = cueball_to_ball(ball1.v,ball2.v,ball_1.pos,ball2.pos)
    
    if ball2.v != vec(0,0,0): #當子球開始移動 xz分量受摩擦力變化
        ball2.v.y = 0
        if ball2.v.x > 1e-10:
            ball2.v.x = ball2.v.x-(bff_x())
        if ball2.v.z > 1e-10:
            ball2.v.z = ball2.v.z-(bff_z())
        ball2.pos += ball2.v *dt #移動
        ball2.rotate(angle=0.1, axis=vec(10*F*np.cos(phi)*np.cos(theta),
                     a1+a2,10*F*np.cos(phi)*np.sin(theta))) #轉動
        if ball2.v.x < 0.001 and ball2.v.z < 0.001: #球停止條件
            ball2.v = vec(0,0,0)
    cueball_to_wall(ball2.pos,ball2.v) #判斷球有沒有撞牆

