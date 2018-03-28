
def func(n):
    rt = float(n)
    return round(rt,4)

no = int(input())
l = list(map(func,input().split()))

for f in range(len(l)-1):
    st = l[f]
    pow = func(l[f]+0.0001)
    en = l[f+1]
    v = 0
    fce=0
    while(pow<=((l[f]+l[f+1])/1.2)):
        fce=0
        for i in range(len(l)):
            d = pow - l[i]
            fce += 1/d
        #print(fce)
        if(fce<=0.0001):
            print ("%.2f" % pow)
            break
        pow=func(pow+0.0001)
  
