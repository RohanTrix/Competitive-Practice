for t in range(int(input())):
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
            