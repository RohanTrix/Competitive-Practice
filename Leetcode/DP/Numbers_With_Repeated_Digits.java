public class Numbers_With_Repeated_Digits {
    Integer dp[][][]; // dp[ind][mask][restrict]
    char NUM[];
    
    public int countNoRep(int ind, int mask, int restrict)
    {   
        int sum = 0;
        if(ind == NUM.length) return 1;
        if(dp[ind][mask][restrict] != null) return dp[ind][mask][restrict];
        int cnt = 0;
        if(restrict == 1)
        {
            for(int i = '0'; i<=NUM[ind]; i++)
            {
                if(ind == 0 && i == '0') continue; // If first digit, cannot put '0'
                
                if((mask & (1<<(i-'0'))) != 0) continue; // If digit already used, cannot put so skip

                if(i == NUM[ind]) // If limit of the current digit reached, next digit will be restricted
                    cnt+= countNoRep(ind+1, mask | (1<<(i-'0')), 1); 
                
                else // Otherwise, next digit unreastricted
                    cnt+=countNoRep(ind+1, mask | (1<<(i-'0')), 0);
            }
        }
        else
        {
            cnt = 1;
            int digs = 0;
            for(int i = 0; i<10; i++)
                digs+=(mask & (1<<i))==0?1:0;
            for(int i = ind; i<NUM.length; i++)
                cnt*=(digs--);
        }
        return dp[ind][mask][restrict] = cnt;
    }
    public int numDupDigitsAtMostN(int n) {
        NUM = Integer.toString(n).toCharArray();
        dp = new Integer[NUM.length][(1<<10)][2];
        int finAns = 0;
        for(int i = 0; i<NUM.length-1; i++)
        {
            int res = 9;
            int options = 9;
            for(int j = 0; j<i; j++) res*=(options--);
            finAns+=res;
        }
        
        finAns+=countNoRep(0, 0, 1);
        
        return n - finAns;
    }
}