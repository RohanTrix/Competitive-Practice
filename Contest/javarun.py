import os
import time
prog_name = "Solution.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes Solution local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)
