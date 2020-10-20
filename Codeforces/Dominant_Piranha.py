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
            al.append(i)
    for i in al:
        if i==0 and l[i+1] <m:
            print(i+1)
            