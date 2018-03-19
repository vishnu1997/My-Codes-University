def annotate(text):
    def decorate(func):
        func.label=text
        print("maggi")
        return func
    return decorate
@annotate('Spam data')
def spam(a,b):
    return a+b
print(spam(5,10),spam.label)