for _ in range(int(input())):
    n = int(input())
    if n and (not(n&(n-1))):
        print(-1)
        continue
    