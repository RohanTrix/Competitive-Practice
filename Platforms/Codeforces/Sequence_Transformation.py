for t in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    d = {}
    if len(l) ==1:
        print(0)
        continue
    for i in range(len(l)):
        if l[i] not in d.keys():
            d[l[i]] = [i]
        else:
            d[l[i]].append(i)
    mini = 9999999
    #print(d)
    for i in d.keys():
        
        if len(d[i]) ==1:
            if (d[i][0] ==0 or d[i][0]==n-1):
                mini = 1
            else:
                mini = min(mini, 2)
        #elif d[i][0] ==0 and d[i][-1]==n-1
        else:
            cnt = 0
            for j in range(1,len(d[i])):
                diff = d[i][j] - d[i][j-1]-1
                if diff>0:
                    cnt+=1
            if d[i][0]!=0:
                cnt+=1
            if d[i][-1]!=n-1:
                cnt+=1
            mini = min(mini, cnt)
    print(mini)
                


