for t in range(int(input())):
    n = input()
    s = input()
    zeros =0
    ones=0
    cnt=0
    s1 = 0
    for i in s:
        if i=='1':
            cnt+=1
        if i=='0' and cnt>0:
            s1+=1
            cnt-=1
    print(s1)