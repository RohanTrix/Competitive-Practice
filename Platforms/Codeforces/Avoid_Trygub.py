for t in range(int(input())):
    n = int(input())
    s = input()
    ss = "trygub"
    k =0
    cnt=0
    l=[]
    for i in range(n):
        if s[i]=='b':
            cnt+=1
    for i in range(cnt):
        print('b',end='')
    for i in range(n):
        if s[i]=='b':
            continue
        print(s[i], end='')
    print()


        
            

