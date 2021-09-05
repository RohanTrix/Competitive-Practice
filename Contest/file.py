import math
from collections import defaultdict, Counter
import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')

for t in range(int(input())):
    a,b,c,d,e = map(int,input().split())
    # maxi = max(a,b,c)
    # mini = min(a,b,c)
    # mid = a+b+c-mini-maxi
    # d-=maxi
    # if (mid<=d and mini<=e) or (mini<=d and mid<=e):
    #     print("YES")
    # else:
    #     print("NO")
    if (a+b<=d and c<=e) or (b+c<=d and a<=e) or (c+a<=d and b<=e):
        print("YES")
        continue
    print("NO")
    
