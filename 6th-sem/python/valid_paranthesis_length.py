str = input()
l = []
start=0
last=0
m=0
for i in range(len(str)):
    s=0
    if str[i]=='(':
        l.append(i)
    else:
        if not l==[]:
            tr=l[-1]
        else:
            continue
        if str[tr]=='(':
            e=l.pop()
            len=i-e
            if(len>m):
                m=len+1

print(m)




