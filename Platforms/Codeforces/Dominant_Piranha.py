def solve():
    n = int(input())
    l = list(map(int,input().split()))
    al = []
    m=-99999999
    b = False
    for i in range(n):
        if m < l[i]:
            m= l[i]
    for i in range(n):
        if l[i]==m:
            al.append(i)
    for i in al:
        if (i==0 and l[i+1] <m) or (i==n-1 and l[i-1] < m):
            print(i+1)
            return
        if ( i> 0 and i< n-1 and (l[i+1] < m or l[i-1]< m)):
            print(i+1)
            return
    print(-1)


for t in range(int(input())):
    solve()
            