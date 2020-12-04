import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
t = int(input())
for _ in range(t):
    n,k = map(int,input().split())
    if k==0:
        l=[-i for i in range(1, n+1)]
    elif k==1:
        l = [-i for i in range(1, n+1)]
        l[0] *=-1
    else:
        l=[]
        for i in range(1, n+1):
            if i%2==0:
                l.append(i)
            else:
                l.append(-i)
        if n%2==0:
            if(k<=n//2):
                jump = (n//2)-k
                ind = n-1
            else:
                jump = k-(n//2)
                ind = n-2
                
        else:
            if(k<=n//2):
                jump = (n//2)-k
                ind = n-2
            else:
                jump = k-(n//2)
                ind = n-1
        for i in range(jump):
            l[ind] *=-1
            ind-=2
    print(*l, sep = ' ')
    s=0
                    




