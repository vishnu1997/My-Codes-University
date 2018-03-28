#generator,yield funtion
def createGenerator():
    mylist = range(3)
    for i in mylist:
        yield i*i
mygenerator = createGenerator()
for i in mygenerator:
    print(i)