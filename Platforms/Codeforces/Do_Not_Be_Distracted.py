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
    n = inp()
    s = strng()
    l = list()
    vis = set()
    i = 0
    if n==1:
        print("YES")
        return
    while(i<n):
        if s[i] not in vis:
            vis.add(s[i])
            last = s[i]
            i+=1
        else:
            if(s[i]==last):
                i+=1
                continue
            else:
                print("NO")
                return
 
    print("YES")
 
 
 
for t in range(int(input())):
    main()
