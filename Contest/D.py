
MAXN = 100001
spf = [0 for i in range(MAXN)] 
import sys 
sys.stdin = open('input.txt', 'r')  
sys.stdout = open('output.txt', 'w+')
def isPrime(n):
    
    if n==1:
        return False
    i = 2
    while i*i<=n:
        if n%i==0:
            print(n, "Checked False")
            return False
        i+=1
    print(n, "Checked true")
    return True

def sieve(): 
    spf[1] = 1
    for i in range(2, MAXN): 
          
        # marking smallest prime factor  
        # for every number to be itself. 
        spf[i] = i 
  
    # separately marking spf for  
    # every even number as 2 
    for i in range(4, MAXN, 2): 
        spf[i] = 2
  
    for i in range(3, int(MAXN**0.5)+1,2): 
          
        # checking if i is prime 
        if (spf[i] == i): 
              
            # marking SPF for all numbers 
            # divisible by i 
            for j in range(i * i, MAXN, i):  
                  
                # marking spf[j] if it is  
                # not previously marked 
                if (spf[j] == j): 
                    spf[j] = i 
  
# A O(log n) function returning prime  
# factorization by dividing by smallest  
# prime factor at every step 
def getFactorization(x): 
    ret = [] 
    while (x != 1):
        fact= spf[x]
        i=0
        while(x%fact==0):
            i+=1
            x = x // fact
        ret.append((fact,i))       
    return ret
sieve()
#print(getFactorization(int(input())))

for t in range(int(input())):
    #print(isPrime(4999999937))
    n = int(input())
    if isPrime(n):
        print(1)
        print(n)
        continue
    maxi = -1
    fact = 0
    l = getFactorization(n)
    for i in l:
        if i[1] > maxi:
            maxi = i[1]
            fact = i[0]
    print(maxi)
    for i in range(maxi-1):
        print(fact, end = ' ')
    print(n//fact**(maxi-1))
