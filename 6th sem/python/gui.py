import tkinter as tk

class Application(tk.Frame):
    def __int__(self,master=None):
        super().__init__(master)
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.hi_there = tk.Button(self)
        self.hi_there["text"] = "Hello world \n (click me)"
        self.hi_there["command"] = self.say_hi
        self.hi_there.pack(side="top")

        self.quit = tk.Button(self,text="QUIT",fg="red",command=root.destroy)
        self.quit.pack(side="bottom")

    def say_hi(self):
        print("hi there whats up ?")

root = tk.Tk()
app = Application(master=root)
app.mainloop()