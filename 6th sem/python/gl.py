v = 0
d={}
def fun(p,q,r):
    s = 0;
    if (q,r) in d:
        return d[q,r]
    if r<=0:
        d[q,r]=1
        return 1
        
    for i in range(q):
        e = r-a[i]
        if e>=0:
            t=fun(p,i+1,e)
            d[i+1,e]=t
            s+=t 
    return s
a =[2,3,5,6]
n = len(a)
m = 10
tot=fun(a,n,m)
print(tot)