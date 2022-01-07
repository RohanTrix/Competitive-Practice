import sys
from bisect import bisect_left
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
for t in range(int(input())):
    n = int(input())
    s1 = input()
    s2 = input()
    l = []
    cnt1 = 0
    cnt0 = 0
    for i in s1:
        if i=='1':
            cnt1+=1
        else:
            cnt0+=1
    for i in s2:
        if i=='1':
            cnt1-=1
        else:
            cnt0-=1
    ll = []
    if cnt1!=0 or cnt0!=0:
        print("No")
        continue
    else: 
        for i in range(n):
            if s1[i]=='0':
                l.append(i)
        for i in range(n):
            if s2[i]=='0':
                ll.append(i)
    f = True
    #print(l,ll)
    for i in range(len(l)):
        if l[i]<ll[i]:
            print("No")
            f = False
            break
    if f:
        print("Yes")
    