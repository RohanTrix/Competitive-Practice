import os
import time
s = "F"
prog_name = f"{s}.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes {s} local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)