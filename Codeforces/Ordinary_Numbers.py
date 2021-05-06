from math import gcd,floor,sqrt,log
mod=1000000007
inp    =lambda: int(input())
strng  =lambda: input().strip()
jn     =lambda x,l: x.join(map(str,l))
strl   =lambda: list(input().strip())
il    =lambda: list(map(int,input().strip().split()))
fl   =lambda: list(map(float,input().strip().split()))
seq    =lambda: list(map(int,input().strip().split()))
 
def main():
    n  =inp()
    p = len(str(n))
    ans = (p-1)*9
    k = 1
    bridge = 0
    for i in range(p):
        bridge+=k*int(str(n)[0])
        k*=10
    if n>=bridge:
        #print(bridge, n)
        ans+=int(str(n)[0])
    else:
        ans+=int(str(n)[0])-1
    print(ans)
 
 
for t in range(int(input())):
    main()