import os
import time
prog_name = "Dice_Combinations.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes Dice_Combinations')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)