import os
import time
while(True):
    if os.system('git diff --exit-code')==0:
        print(0)
        time.sleep(60)
        os.system('git add .')
        continue
    os.system('git add-commit -m "Committed changes"')
    os.system('git push -u origin master')
    time.sleep(60)
