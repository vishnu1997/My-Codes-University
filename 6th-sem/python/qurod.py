v = 0
d={}
mx = 0
rl=1
jx=0
l={}
rt=[]
rt.append(1)
ld=[]

#rt[0]=1
def fun(p,q,r,mx):
    t=0
    if(r<=0):
        if(rt[0]==1):
            ld.append(str(mx))
            rt[0]=0
        l[mx]=0
        return 1
    for i in range(q):
        e = r - p[i]
        if e>=0:
            
            #print(str(e)+"--")
            t+=fun(p,q,e,mx+1)
    return t
a =[2,3,5]
b =[6,5,3,2]
n = len(a)
m = 7
#tot=fun(a,0,m)
#print("hii")
del d
d ={}
tot1 = fun(a,len(a),m,mx)
ld.append(str(min(l.keys())))
#print(str(tot1)+"====")
if(len(ld)!=0):
    ld.sort()
    s = ld[0]+" "+ld[1]
else:
    s = "-1"
print(s)