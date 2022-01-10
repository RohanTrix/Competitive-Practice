import math
from collections import defaultdict, Counter
import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
 

for t in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    
    l.sort()

    s1 = set([i for i in range(1,n+1)])
    s2 = set(l)
    s = s2 - s1
    print(s)
    
            


    
    