import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
for t in range(int(input())):
    ans = -1
    n = int(input())
    l = list(map(int,input().split()))
    d = {}
    for i in l:
        if i not in d:
            d[i] = 1
        else:
            d[i]+=1
    mini = 99999999999999
    for i in range(n):
        if d[l[i]] ==1:
            if l[i] < mini:
                mini = l[i]
                ans = i+1
    print(ans)
            
