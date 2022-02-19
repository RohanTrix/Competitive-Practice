# list(map(int,input().split()))

import math
from collections import defaultdict, Counter
import sys


# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')

# for t in range(int(input())):

n,k = map(int, input().split())
l = list(map(int,input().split()))
ans = -1
sto = 0
for i in range(n):
    sto+=l[i]
    k-=min(sto,8)
    sto-=min(sto,8)
    if(k<=0):
        ans = i+1
        break
print(ans) 