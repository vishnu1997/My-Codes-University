d={}
def calc(l,i,s):
    if i in d.keys():
        if(d[i]>s):
            return d[i]
        else:
            d[i]=s
            return s
    print(i,s)
    if(i>=len(l)):
        return s
    else:
        sum1=s+l[i]
        c = (max(calc(l,i+1,s),calc(l,i+2,sum1)))
        print("mmmmmmm")
        print(i,c)
        if i in d.keys():
            if(d[i]<c):
                d[i]=c
        else:
            d[i]=c
        return d[i]

#li=list(map(int,input().split()))
li = [90,40,50,80]
cl = calc(li,0,0)
print(cl)
