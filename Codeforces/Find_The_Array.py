import math
for t in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    b = []
    for i in a:
        k = 2**int(math.log2(i))
        if i-k<(2*k)-i or 2*k>10**9:
            b.append(k)
        else:
            b.append(2*k)
    print(*b, sep = ' ')