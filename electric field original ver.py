import numpy as np
import matplotlib.pyplot as plt
x=np.array([-0.5+0.002*i for i in range(501)]) #拆幾個點(-0.5+0.002*(501-1)=0.5)
y=np.array([-0.5+0.002*i for i in range(501)])
u=np.array([[0.0 for i in range(501)] for j in range(501)])
v=np.array([[0.0 for i in range(501)] for j in range(501)])
for i in range(501):
    for j in range(501): #x[j]代表先跑完x再跑y(固定y)
        rp=((x[j]+0.1)**2+y[i]**2)**0.5 #(-0.1,0), r of positive
        rn=((x[j]-0.1)**2+y[i]**2)**0.5 #(0.1,0), r of negative
        u[i][j]=(x[j]+0.1)/rp**3-(x[j]-0.1)/rn**3 #r_direct/r^3(x方向)
        v[i][j]=(y[i]-0)/rp**3-(y[i])/rn**3 #r_direct/r^3(y方向)
k=(u**2+v**2)**0.5 #r方向
for i in range(501):
    for j in range(501):
        if k[i][j]>1e+10: #過大時歸0
            u[i][j]=0
            v[i][j]=0
plt.streamplot(x,y,u,v,color=np.log(k)) #流線圖
plt.colorbar()
plt.plot(0.1,0,'x',color="green")
plt.plot(-0.1,0,"o",color="blue")