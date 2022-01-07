import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')

for t in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    f = True
    if len(l)==1:
        print("YES")
        continue
    psum = []
    s = 0
    for i in range(len(l)):
        psum.append(i+s)
        s = s+i
    currSum = 0
    for i in range(len(l)):
        currSum+=l[i]
        if currSum<i*(i+1)//2:
            f = False
            break
    if f:
        print('yes')
    else:
        print('no')