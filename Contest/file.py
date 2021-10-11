import math
from collections import defaultdict, Counter
# import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')


for t in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    mean = sum(l)/n
    # if sum(l)>n and (sum(l)%n)!=0:
    #     print(0)
    #     continue
    
    d = Counter(l)
    cnt = 0
    for k in d.keys():
        if k<mean:
            if 2*mean - k in d:
                cnt+=(d[k]*d[(2*mean) - k])
    


    if d[mean]!=0:
        cnt+=(d[mean]*(d[mean]-1))//2
    print(cnt)
