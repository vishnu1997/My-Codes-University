d={}
def walk(i,j,m,n,s):
    if (i,j) in d.keys():
        print("mmmm")
        return d[i,j]
    
    if(i==m)and(j==n):
        return s+1
    if(i>m) or j>n:
        return 0
    t=walk(i+1,j,m,n,s)
    d[i+1,j]=t
    #print(i+1,j,j)
    r=walk(i,j+1,m,n,s)
    d[i,j+1]=r
    #print("r::")
    #print(i,j+1,r)
    return t+r


m=10
n=20
import time
start_time = time.time()
print(walk(0,0,m-1,n-1,0))

tr = time.time()
print(tr-start_time)

"""
1522756191.802384
1522756356.538742
1522756355.11
"""
