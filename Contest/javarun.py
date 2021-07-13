import os
import time
prog_name = "Solution"
os.system(f'javac -d Classes {prog_name}.java')
t1 = time.time()
os.system(f'java -cp Classes {prog_name} local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)


