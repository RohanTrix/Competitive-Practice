import os
import time
prog_name = "*.java"
os.system(f'javac -d Java-Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Java-Classes POLYREL')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)