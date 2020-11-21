import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') 
for _ in range(int(input())):
    n, q = map(int,input().split())
    s = input()
    
    for i in range(q):
        i, j = map(int,input().split())
        i = i-1
        j = j-1
        left = s[i]
        right = s[j]
        a=b=0
        f = "NO"
        i -=1
        j+=1
        while(i>=0 or j<n):
            if i>=0 and s[i]==left:
                f="YES"
                break
            if j<n and s[j]==right:
                f = "YES"
                break
            i-=1
            j+=1
        print(f)



    