import os
import time
prog_name = "Main"
JAVAC_PATH = "D:\\Programs\\Java\\jdk-17.0.5\\bin\\javac.exe"
JAVA_PATH = "D:\\Programs\\Java\\jdk-17.0.5\\bin\\java.exe"
os.system(f'{JAVAC_PATH} -d Classes {prog_name}.java')
t1 = time.time()
os.system(f'{JAVA_PATH} -cp Classes -Xss30m {prog_name} local')
t2 = time.time()
print("\n\nTIME TAKEN: ",t2-t1)
