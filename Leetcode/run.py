import os
import time
prog_name = "A.cpp"
os.system(f'g++ -o out {prog_name}')
t1 = time.time()
os.system("out")
t2 = time.time()
print(t2-t1)