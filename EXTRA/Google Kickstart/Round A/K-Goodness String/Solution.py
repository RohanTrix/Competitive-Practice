for t in range(int(input())):
    n, k = map(int,input().split())
    s = input()
    c =0
    for i in range(1,n//2+1):
        if s[i-1]!=s[n-i]:
            c+=1
    ans = abs(k-c)
    print(f"Case #{t+1}: {ans}")