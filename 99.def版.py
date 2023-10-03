import random
player=[]
computer=[]
def shuffles():
    slot=[]
    for j in range(4):
        for i in range(1,14):
            if j==0:
                slot.append(["spade",i])
            elif j==1:
                slot.append(["heart",i])
            elif j==2:
                slot.append(["diamond",i])
            elif j==3:
                slot.append(["club",i])
    m=random.randint(48,52)
    for i in range(m):
        j=random.randint(0,51)
        k=random.randint(0,51)
        if j!=k:
            copyplace=slot[j]
            slot[j]=slot[k]
            slot[k]=copyplace
    return slot
def reshuffle(discard,slot):
    for i in range(40):
        j=random.randint(0,40)
        k=random.randint(0,40)
        if j!=k:
            copyplace=discard[j]
            discard[j]=discard[k]
            discard[k]=copyplace
    for i in range(40):
        slot.append(discard[i])
    return slot
def playerw(slot,num,turns,discard):
    print(player)
    n=eval(input("choose a card(1-5): "))
    n-=1
    if n<5:
        print("Player_Throw",player[n])
        discard.append(player[n])
        if player[n][1]==11: #pause
            turns+=1
        elif player[n][1]==10: #+/-10
            pm=eval(input("plus or minus?(1 for plus;0 for minus)  "))
            if pm==1:
                num+=10                 
            elif pm==0:
                num-=10
            turns+=1
        elif player[n][1]==12: #+/-20
            pm=eval(input("plus or minus?(1 for plus;0 for minus)  "))
            if pm==1:
                num+=20
            elif pm==0:
                num-=20
            turns+=1
        elif player[n][1]==13: #reach 99
            num=99
            turns+=1     
        else:
            num+=player[n][1]
            turns+=1
        player.append(slot[0])
        del slot[0]
        print("current number: %d"%num)
        del player[n]
    else:
        print("invalid input")
    return slot,num,turns,discard
def computerw(slot,num,turns,discard):
    for i in range(5):
        for j in range(5):
            if computer[i][1]<computer[j][1]:
                switch=computer[i]
                computer[i]=computer[j]
                computer[j]=switch
    n=0
    for i in range(5):
        if (num+computer[i][1])<100:
            if computer[i][1]<10:
                n=i
    if (num+computer[n][1])>99:
        for i in range(5):
            if computer[i][1]>9:
                n=i
    print("Computer_Throw",computer[n])
    discard.append(computer[n])
    if computer[n][1]==11: #pause
        turns+=1
    elif computer[n][1]==10: #+/-10
        if num>89:
            num-=10
        else:
            num+=10
        turns+=1
    elif computer[n][1]==12: #+/-20
        if num>79:
            num-=20
        else:
            num+=20
        turns+=1
    elif computer[n][1]==13: #reach 99
        num=99
        turns+=1     
    else:
        num+=computer[n][1]
        turns+=1
    computer.append(slot[0])
    del slot[0]
    print("current number: %d"%num)
    del computer[n]
    return slot,num,turns,discard
def main():
    slot=shuffles()
    discard=[]
    num=0
    turns=0
    for i in range(5):
        player.append(slot[(2*i)])
        computer.append(slot[1+(2*i)])
    a=0
    while a<10:
        del slot[0]
        a+=1  
    while num<120:
        if len(discard)>40:
            slot=reshuffle(discard,slot)
            discard=[]
        if num>99:
            print("Game Over")
            break
        else:
            if turns%2==0:
                slot,num,turns,discard=playerw(slot,num,turns,discard)
            else:
                slot,num,turns,discard=computerw(slot,num,turns,discard)               
main()

