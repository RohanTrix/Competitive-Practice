import math

def main():
    n = int(input())
    l = list(input())
    ans = []
        
    for i in range(n):
        if l[i]=="?":
            ans.append(-1)
        else:
            ans.append(l[i])
    
        
    
    d = {"B": "R", "R":"B"}
    i = 0
    pos1 = -1
    while(i<n):
        if l[i]!='?':
            pos1= i
            break
        i+=1
    i = pos1-1
    if pos1 == -1:
        ans = ["B"]
        for i in range(1,n):
            ans.append(d[ans[i-1]])
        print(*ans, sep = '')
        return
    while(i>=0):
        ans[i] = d[ans[i+1]]
        i-=1
    i = pos1+1
    while(i<n):
        if l[i]!="?":
            ans[i] = l[i]
        else:
            ans[i] = d[ans[i-1]]
        i+=1
    print(*ans, sep='')








t = int(input())
for _ in range(t):
    main()
 
 
