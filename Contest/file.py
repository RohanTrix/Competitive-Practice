import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w') 
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
    a,b,c = map(int,input().split())
    print((b+(100-a)*c)*10)

for t in range(int(input())):
    main()

