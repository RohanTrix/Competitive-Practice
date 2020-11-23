for _ in range(int(input())):
    a = list(input())
    b = list(input())
    moves=0
    cnt=0
    i=0
    while(i<len(a)):
        if a[i] != b[i]:
            cnt+=1
            j=i
            while(j < len(a) and a[j]!=b[j]):
                a[j] = '0'
                b[j] = '0'
                j+=2
        i+=1
    print(cnt)