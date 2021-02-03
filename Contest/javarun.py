import os
import time
<<<<<<< HEAD
prog_name = "Tree.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes Tree local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)
||||||| eff9a9c
import tkinter as tk
from tkinter import ttk
win = tk.Tk()  
win.title("JAVARUN")
def click_me():
    prog_name = "B.java"
    os.system(f'javac -d Classes {prog_name}')
    t1 = time.time()
    os.system(f'java -cp Classes B local')
    t2 = time.time()
    print("TIME TAKEN: ",t2-t1)
# Adding a button
action = ttk.Button(win, text = "Click me!", command = click_me)
action.grid(column=1, row=0)
win.mainloop()
=======
prog_name = "A.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes A local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)
>>>>>>> 9e24aec64d7118bb911301c86f5b1dd6a5c53f40
