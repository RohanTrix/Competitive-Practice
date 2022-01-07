import sys
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w')
D1, V1, D2, V2, P = map(int,input().split())
amt = 0
done  = False
if(D1 < D2):
    while(amt<P and D1<D2):
        amt+=V1
        D1+=1
    if amt>=P:
        print(D1-1)
    else:
        while(amt<P):
            amt+=V1+V2
            D1+=1
        print(D1-1)
else:
    while(amt<P and D2<D1):
        amt+=V2
        D2+=1
    if amt>=P:
        print(D2-1)
    else:
        while(amt<P):
            amt+=V1+V2
            D2+=1
        print(D2-1)
    
