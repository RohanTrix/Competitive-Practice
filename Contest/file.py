import math
from collections import defaultdict, Counter
import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
 

for t in range(int(input())):
    n = int(input())
    l1 = list(map(int,input().split())) + list(map(int,input().split()))
    l1.sort()
    print(l1)
    print(max(l1[:n])*max(l1))
