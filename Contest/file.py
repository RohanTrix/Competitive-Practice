import math
import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')


def isperf(x):

    return math.ceil(math.sqrt(x)) == math.floor(math.sqrt(x))
     
def main():
    x,y = map(int,input().split())
    if x==1 and y==1:
        print(1)
        return
    maxi = max(x,y)
    mini = min(x,y)
    ans = (maxi-2)*(mini-1) + mini
    if x==y:
        print(ans)
    else:
        print(ans-1)



t = int(input())
for _ in range(t):
    main()
 
 
