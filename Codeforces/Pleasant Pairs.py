import math
# import sys
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w+')

# Check Youtube for explanation
    
for t in range(int(input())):
    n = int(input())
    arr = [(el, i+1) for i,el in enumerate(list(map(int,input().split())))]
    arr.sort()
    cnt, limit = 0, 2*n
    
    limReached = False
    for i in range(n-1):
        for j in range(i+1, n):
            mul = arr[i][0]*arr[j][0]
            if(mul>limit):
                
                break
            if(mul==arr[i][1]+arr[j][1]):
                #print(arr[i], arr[j])
                cnt+=1
        
    print(cnt)

