import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
t = int(input())
for _ in range(t):
    n, d = map(int,input().split())
    l = list(map(int,input().split()))
    risk = nrisk = 0
    for i in l:
        if i>9 and i<80:
            nrisk+=1
        else:
            risk+=1
    num = risk//d + (nrisk//d)
    if risk%d!=0:
        num+=1
    if nrisk%d!=0:
        num+=1
    print(num)