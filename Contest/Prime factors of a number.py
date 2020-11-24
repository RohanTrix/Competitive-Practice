
MAXN = 100001
spf = [0 for i in range(MAXN)] 

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
    ret = list() 
    while (x != 1):
        ret.append(spf[x])
        fact= spf[x]
        while(x%fact==0):
            x = x // fact          
    return ret
sieve()
print(getFactorization(int(input())))