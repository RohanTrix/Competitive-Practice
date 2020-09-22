import os
import time
prog_name = "prog.py"
t1 = time.time()
os.system(f'python {prog_name}')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)