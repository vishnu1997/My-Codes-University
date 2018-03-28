d={
    "a":"c",
    "b":"k",
    "c":"u",
    "d":"q",
    "e":"z",
    "f":"g",
    "g":"a",
    "h":"f",
    "i":"w",
    "j":"s",
    "k":"o",
    "l":"l",
    "m":"b",
    "n":"p",
    "o":"j",
    "p":"v",
    "q":"t",
    "r":"d",
    "s":"i",
    "t":"h",
    "u":"n",
    "v":"y",
    "w":"e",
    "x":"r",
    "y":"x",
    "z":"m",

}
p={
    "0":"2",
    "1":"4",
    "2":"7",
    "3":"1",
    "4":"5",
    "5":"6",
    "6":"0",
    "7":"3",
}
inp =open("encr.txt","r")
s=inp.read()
print("encrypted message: "+s)
#print(len(s))
w=""

for key in p.keys():
   w+=s[int(p[key])]
t=""
for i in range(len(w)):
    t+=d[w[i]]
print("message decrypted: "+t)
