# list(map(int,input().split()))

import math
from collections import defaultdict, Counter
import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')

for t in range(int(input())):
    n,k = map(int,input().split())
    f = True
    cnt = 0
    s = input()
    for i in range(n//2):
        if(s[i]!=s[-i-1]):
            cnt+=1
        if(cnt>k):
            print("NO")
            f = False
    
    if(not f):
        continue
    if((n%2!=0) or (k-cnt)%2==0):
        print("YES")
    else:
        print("NO")
    
        
