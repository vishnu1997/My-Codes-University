d={}
l1 = list(map(int,input().split(',')))
x=l1[1]
y=l1[0]
b=l1[2]
leng=[]
leng.append(x)
leng.append(y)
leng.append(b)
def fun(x,y,t,b):
    if (x,y,b) in d.keys():
        temp = d[(x,y,b)]
        if(t<temp):
            d[x,y,b]=t
        else:
            return
    if x<0 or y<0 or x>=leng[1] or y>=leng[0]:
        return
    d[(x,y,b)]=t
    fun(x,y-1,t+1,b)
    fun(x-1,y,t+1,b)
    fun(x,y+1,t+1,b)
    fun(x+1,y,t+1,b)
    return
d2={}
def che():
    for i in range(leng[1]):
        for j in range(leng[0]):
            se = set([]);
            for r in range(leng[2]):
                se.add(d[i,j,r])
            if (len(se)==1):
                d2[(i,j)]=d[i,j,r]
for i in range(b):
    l2 = list(map(int,input().split(',')))
    fun(l2[1],l2[0],0,i)
che()
print(len(d2))