def sum(n):
    if n==1:
        return 1
    else:
        return n+sum(n-1)

def sum1(a,n):
    if(n<0):
        return 0
    else:
        return a[n]+sum1(a,n-1)

n=input("enter n ")
print(sum(n))

l = list(map(int,input().split()))
print(sum1(l,len(l)-1))

for i in range(len(l)):
    if(l[i]%2==0):
        print("even"+str(l[i]))
    else:
        print("even"+str(l[i]))

