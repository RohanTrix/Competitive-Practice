for _ in range(int(input())):
    n = int(input())
    #Checking if n is a power of 2
    if n and (not(n&(n-1))):
        print(-1)
        continue
