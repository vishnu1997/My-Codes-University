class fruits:
    def __init__(self):
        self.names=[]
        print("fruits")

class juicy(fruits):
    def __init(self):
        super().__init__()
    def add(self,name):
        self.names.append(name)
    def show(self):
        #assert(se>=0),"hiii"
        print(self.names)
x = juicy()
x.add("maggi")
x.show()