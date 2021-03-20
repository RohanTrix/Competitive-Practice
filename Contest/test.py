import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
for t in range(int(input())):
    n, w = map(int,input().split())
    l = sorted(list(map(int,input().split())))
    amt  = c = i = 0
    while(i<len(l) and amt<=w):
        if(amt+l[i]>w):
            break
        amt+=l[i]
        c+=1
        i+=1
    print(f"Case #{t+1}: {c}")