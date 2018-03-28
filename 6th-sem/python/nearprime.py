n = int(input())

def prim(n):
    v=0
    if(n==0):
        return False
    for i in range(1,int(n/2)+2):
        if(n%i==0):
            v+=1
        if(v>1):
            return False
    return True

def near(n):
    lv=0
    rv=0
    if(n==1 or n==0):
        return 2
    for i in range(n-1,1,-1):
        #print(i)
        if(prim(i)):
            lv=i
            break
    rv=n+1
    while(not prim(rv)):
        rv+=1
    if((rv-n)>(n-lv)):
        return lv
    elif (rv-n)<(n-lv):
        return rv
    else:
        return lv

print(near(n))
#print(prim(4))
