public class Count_Special_Integers {
    /* PRE-REQ => Digit DP states...refer OneNote
     *
     * IDEA : Digit DP + Bitmasking + Permutations
     *        I solve the numbers of length == num.length using Digit DP...and rest of length <n using Permutations
     * 
     * 
     *        For length  == n, we use `restrict` parameter...to keep number under the limit num... Also, for first position we cannot
     *        use '0'...so that if condition is handled...we also use a Bitmask to keep track of the numbers we have already used
     *        For any length < n...at first positon we can put (1 - 9)..so 9 options...and then from second position onwards,
     *        we can put (0-9 excluding the one used at first position)...so again 9 options, then next position will have 8 options
     *        and so on.
     * 
     */
    char num[];
    Integer dp[][][];
    public int count(int ind, int mask, int restrict)
    {
        if(ind == num.length) return 1;
        if(dp[ind][mask][restrict]!=null)
            return dp[ind][mask][restrict];
        int cnt = 0;
        if(restrict == 0)
        {
            for(int i = 0; i<10; i++)
                if((mask&(1<<i))==0)
                    cnt+=count(ind+1, mask|(1<<i), 0);
        }
        else
        {
            for(int i = 0; i<=num[ind]-'0'; i++)
            {
                if(ind == 0 && i == 0) 
                continue;
                if(i == num[ind]-'0')
                {
                    if((mask&(1<<i)) == 0)
                    cnt+=count(ind+1, mask|(1<<i), 1);
                }
                else
                {
                    if((mask&(1<<i))==0)
                        cnt+=count(ind+1, mask|(1<<i), 0);
                }
            }
        }
        return dp[ind][mask][restrict] = cnt;
    }
    public int countSpecialNumbers(int n) {
        num = Integer.toString(n).toCharArray();
        dp = new Integer[num.length][1<<10][2];
        int cnt = count(0, 0, 1);
        
        // Calculating factorials
        int fact[] = new int[10];
        fact[0] = 1;
        for(int i = 1; i<10; i++) fact[i] =i*fact[i-1];

        // Using permutations for all numbers with length < num.length
        for(int i = 1; i<num.length; i++)
        {
            int res = 9;
            int v = 9;
            for(int j = 2; j<=i; j++ )
            {
                res*=v; v--;
            }
            
            cnt+=res;
        }
        return cnt;
    }
}
