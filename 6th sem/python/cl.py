class Super:
    def method(self):
        print("in super method")
class Sub:
    def method(self):
        print("startin sub")
        Super.method(self)
        print("ending")
x = Super()
print(x.method())
y=Sub()
print(y.method())
print("i am a mad")
print(x.method())
#create a class fruits which consissts of fruit names ,,
# have two sub classes juicy and non juicy fruits
#get values from the users ,the juicy fruits will apppend a new fruit and the non 
# juicy fruit class is used to delete the fruit names...use pop and append commands 
# to delete the list of fruits 