import math
from collections import defaultdict, Counter
import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')




for t in range(int(input())):
    n = int(input())
    l = ['()' for i in range(n)]
    for i in range(n):
        print(*l, sep  ='')
        if len(l)==1:
            break
        l[1] = l[1][0]+l[0]+l[1][1]
        del l[0]
    
