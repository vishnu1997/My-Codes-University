import random

d={ "a":"g",
    "b":"m",
    "c":"a",
    "d":"r",
    "e":"w",
    "f":"h",
    "g":"f",
    "h":"t",
    "i":"s",
    "j":"o",
    "k":"b",
    "l":"l",
    "m":"z",
    "n":"u",
    "o":"k",
    "p":"n",
    "q":"d",
    "r":"x",
    "s":"j",
    "t":"q",
    "u":"c",
    "v":"p",
    "w":"i",
    "x":"y",
    "y":"v",
    "z":"e",
}
p={
    "0":"6",
    "1":"3",
    "2":"0",
    "3":"7",
    "4":"1",
    "5":"4",
    "6":"5",
    "7":"2",
}

x = input("enter string of 8 character blocks");
u=(len(x)/8)
s=""
for i in range(len(x)):
    s+=d[x[i]]
print()
print("After substitution we get: "+s)
w=""
# for j in range(u):
for key in p.keys():
   w+=s[int(p[key])]
print()
print("After Permutation(encrypted message) : "+w)

out = open("encr.txt","w")
out.write(w)

# l=[i for i in range(8)]
# print(l)
# print("----")
# while(len(l)!=0):
#     x=random.choice(l)
#     print(x)
#     l.remove(x)
    # for i in range(len(l)):
    #     if x in l:
    #         l.pop(i)