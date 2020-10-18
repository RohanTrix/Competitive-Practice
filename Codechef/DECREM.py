import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
for t in range(int(input())):
    l,r = map(int, input().split())
    if 2*l <=r:
        print(-1)
    elif l==1:
        print(-1)
    else:
        print(r)