import math

def nextPerfectSquare(N):
 
    nextN = math.floor(math.sqrt(N)) + 1
 
    return nextN * nextN

def isperf(x):

    return math.ceil(math.sqrt(x)) == math.floor(math.sqrt(x))
     
def main():
    k = int(input())
    if k==1:
        print(1,1)
        return
    up = nextPerfectSquare(k)
    if(isperf(k)):
        print(int(k**0.5),1)
        return

    sqrt_up = int(up**0.5)
    low = (sqrt_up - 1)*(sqrt_up - 1) +1
    if(up-k==k-low):
        print(sqrt_up, sqrt_up)
    elif up-k<k-low:
        val = up-k+1
        print(sqrt_up, val)
    else:
        val = k-low+1
        print(val, sqrt_up)


t = int(input())
for _ in range(t):
    main()
 
 
