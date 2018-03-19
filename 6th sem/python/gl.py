v = 0
d={}
mx = 0
rl=1
jx=0
def fun(p,q,r,mx,jx):
    s = 0
    if (q,r) in d:
        #print(mx)
        return d[q,r]
    if r==0:
        # if(r==0):
        print(str(mx)+"---")
        #     print(str(jx)+"....")
        d[q,r]=1
        
        
        return 1
        
    for i in range(q):
        e = r-a[i]
        if e>=0:
            mx+=1
            t=fun(p,i+1,e,mx,jx+1)
            #jx+=1
            d[i+1,e]=t
            s+=t 
    return s



a =[2,3,5,6]
b =[8,5,4,2]
n = len(a)
m = 11
tot=fun(a,n,m,mx,jx)
print("hii")
del d
d ={}
#tot1 = fun(a,n,m,mx,jx)
#print(tot)