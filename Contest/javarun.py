import os
import time
prog_name = "Main"
os.system(f'javac -d Classes {prog_name}.java')
t1 = time.time()
os.system(f'java -cp Classes -Xss30m {prog_name} local')
t2 = time.time()
print("\n\nTIME TAKEN: ",t2-t1)
