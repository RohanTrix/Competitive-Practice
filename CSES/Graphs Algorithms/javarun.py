import os
import time
prog_name = "Main.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes Main local')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)
