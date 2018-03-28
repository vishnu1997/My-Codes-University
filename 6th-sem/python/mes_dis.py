from tkinter import *
import tkinter.messagebox
top =Tk()
top.geometry("200x200")
def bclick():
    msg = tkinter.messagebox.showinfo("me page","Good morning")

B = Button(top,text="hello",command=bclick)
B.place(x=100,y=100)
top.mainloop()