import math
def isPower (x, y):
    res1 = math.log(y) // math.log(x)
      
    # Note : this is double 
    res2 = math.log(y) / math.log(x) 
  
    # compare to the result1 or 
    # result2 both are equal 
    return True if(res1 == res2) else False
for t in range(int(input())):
    n,k = map(int,input().split())
    arr = list(map(int,input().split()))
    for i in range(len(arr)):
        arr[i] = arr[i]%k
    f = True
    for i in arr:
        if i==0:
            continue
        else:
            q=1
            while(q*i<=10**9):
                q*=2
                i = q*i
            if (q*i)%k!=0:
                f = False
                break
    if f:
        print("YES")
    else:
        print("NO")
