n = 2*1000000
prime = [True for i in range(n+1)]
def SieveOfEratosthenes(): 
     
    p = 2
    while (p * p <=n): 
          
        if (prime[p] == True): 
               
            for i in range(p * p, n+1, p): 
                prime[i] = False
        p += 1
SieveOfEratosthenes()
for t in range(int(input())):
    poi = 2
    n = int(input())
    l = list(map(int,input().split()))
    d={}
    for i in range(n):
        if l[i] not in d.keys():
            print(poi, end= ' ')
            d[l[i]] = poi
            poi+=1
            while(prime[poi]!=True):
                poi+=1
        else:
            print(d[l[i]], end=' ')
    print()