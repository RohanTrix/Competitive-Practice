public class Non_negative_Integers_without_Consecutive_Ones
{
    // REFER : DIGIT DP on the bits
    Integer dp[][][]; // dp[i][prev][restrict]
    int limit;
    public int count(int i, int prev, int restrict)
    {
        if(i == -1) return 1;
        if(dp[i][prev][restrict]!=null) return dp[i][prev][restrict];
        int cnt = 0;
        if(restrict == 0)
        {
            cnt = count(i-1,0,0);
            if(prev == 0)
                cnt+=count(i-1,1,0);
        }
        else
        {
            int dig = (limit&(1<<i)) == 0?0:1;
            if(dig == 0)
                cnt = count(i-1,0,1);
            else
            {
                cnt = count(i-1,0,0);
                if(prev == 0)
                    cnt+=count(i-1,1,1);
            }
        }
        return dp[i][prev][restrict] = cnt;
    }
    public int findIntegers(int n) {
        limit = n;
        dp = new Integer[32][2][2];
        return count(31,0,1);
    }
}