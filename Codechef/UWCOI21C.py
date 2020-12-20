for t in range(int(input())):
    n,k = map(int,input().split())
    l = list(map(int,input().split()))
    ll = [[i,l[i]] for i in range(n+1)]
    zipped = sorted(ll,key = lambda x: x[1])
    left = 0
    right = n
    while(left<right):
        if(zipped[left][1]+zipped[right][1]<k):
            right-=1
            print(zipped[right][0], k-zipped[right+1][1],zipped[right+1][0], 
                        zipped[right+1][1],sep = ' ')
            continue
        print(*zipped[left],zipped[right][0],k-zipped[left][1], sep = ' ')
        zipped[right][1] -= k-zipped[left][1]
        left+=1
        if(zipped[right][1]==0):
            right-=1
        if(left==right and zipped[left][1]!=0):
            print(zipped[left][0],zipped[left][1],0,0,sep = ' ')