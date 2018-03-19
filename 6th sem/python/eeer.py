import math
t = int(input())
for i in range(t):
    n = int(input())
    r = int(math.sqrt(n))
    while(n%r!=0):
        r+=1
    print(r)
    er = n/r
    print(er)
    
