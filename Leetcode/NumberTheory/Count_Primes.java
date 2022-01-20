public class Count_Primes {
    public int genPrimes(int n)
    {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, 2, n, true);
        n--;
        for(int i = 2; i*i<=n; i++)
        {
            if(prime[i])
            {
                
                for(int j = i*i; j<=n; j+=i)
                {
                    prime[j] = false;
                }
            }
        }
        int cnt = 0;
        for(int i =0; i<prime.length; i++) if(prime[i])cnt++;
        return cnt;
    }
    public int countPrimes(int n) {
        if(n==0 || n==1) return 0;
        return genPrimes(n);
    }
}
