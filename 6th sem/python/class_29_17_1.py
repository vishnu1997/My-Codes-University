
a = str(input("enter 5 digit binary value "))
if(len(a)<5):
    b = int(a,2)
    print("decimal "+str(b))

    c = oct(b)
    print("octal "+str(b))

    d = hex(b) 
    print("hextal "+str(b))
else:
    print("wrong ")