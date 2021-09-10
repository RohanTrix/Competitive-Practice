import math
from collections import defaultdict, Counter
import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')


def ops(P,Q):
    if P[0]==Q[0] or P[1]==Q[1]:
        return 1
    if abs(P[0]-Q[0])==abs(P[1]-Q[1]):
        return 1
    return 2

for t in range(int(input())):
    n = int(input())
    X = list(map(int,input().split()))
    Y = list(map(int,input().split()))
    pair = []
    for x,y in zip(X,Y):
        pair.append([x,y])
    
    
    cnt = 0
    mini = float("inf")
    for i in range(n):
        cnt = 0
        for j in range(n):
            if i==j:
                continue
            cnt+=ops(pair[j], pair[i])
        mini = min(mini,cnt)
    print(mini)