import math
from collections import defaultdict
# import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')

     
for t in range(int(input())):
    d = defaultdict(int)
    n = int(input())
    arr = list(map(int,input().split()))
    cnt = 0
    for i in range(n):
        d[arr[i]-(i+1)]+=1
    for val in d.values():
        if val>1:
            cnt+= val*(val-1)//2
    # print(*d.values())
    print(cnt)