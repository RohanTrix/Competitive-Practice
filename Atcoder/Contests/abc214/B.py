s,t  = map(int,input().split())
cnt = 0
for a in range(101):
    for b in range(101):
        for c in range(101):
            if(a+b+c)<=s and a*b*c<=t:
                cnt+=1
print(cnt)
