for _ in " "*int(input()):
    n,c1,c2,h = map(int, input().split())
    s = input()
    cnt1, cnt2 =0, 0
    for i in s:
        if i=='0':
            cnt1+=1
        else:
            cnt2+=1

    if c1+h<c2:
        print(c1*n + h*cnt2)
    elif c2+h< c1:
        print(c2*n +h*cnt1)
    else:
        print(c1*cnt1 + c2*cnt2)
