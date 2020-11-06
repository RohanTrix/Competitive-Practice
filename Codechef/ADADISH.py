for t in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    l.sort(reverse=True)
    s =l[0]
    rem = l[0]
    if len(l)==1:
        print(l[0])
        continue
    for i in range(1,n):
        if rem>=l[i]:
            rem = rem - l[i]
        else:
            rem = l[i]-rem
            s = s+rem
        #print("Sum = ", s)
        #print("rem = ",rem)
    print(s)
