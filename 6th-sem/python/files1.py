import hashlib
# import json
# mess = "I can do 1 2 3 "
dict={}
ino = int(input("enter no . of users"))
for i in range(ino):
    inpu = input("enter user")
    pas = input("enter pass")
    dict[inpu]=hashlib.sha1(pas.encode('utf-8')).hexdigest()
output = open("test.txt","w")
for x in dict:
    val = dict[x]
    output.write(x+" "+val+"\n")

# with open('file.txt', 'w') as file:
#      file.write(json.dumps(dict))

#output.write("\n"+hashlib.sha256(pas.encode('utf-8')).hexdigest()) 