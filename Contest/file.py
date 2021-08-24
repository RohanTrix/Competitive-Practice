import math
import sys
from typing import Counter 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')

for t in range(int(input())):
    s = input()
    l = ['' for i in range(len(s))]
    freq = Counter(s)
    ans = "IMPOSSIBLE"
    if max(freq.values())>len(s)//2:
        print(f"Case #{t+1}: {ans}")
        continue
    
    i = 0
    #print(freq)
    for k in sorted(freq.keys()):
        i = 0
        v = freq[k]
        #print("Curr key" , k)
        while(v>0):
            if(k!=s[i] and l[i]==''):
                l[i] = k
                v-=1
            i+=1
            if(i==len(s)): break
            #print(l)
            

    ans = ''.join(l)
    print(f"Case #{t+1}: {ans}")