public class Number_of_Smooth_Descent_Periods_of_a_Stock {

    // If i and i-1 th elements form a valid descent, then ith can extend all the descents that i-1 has.
    // DP STATE : dp[i] = No. of descents that end at ith
    // DP TRANS : dp[i] = 1 + dp[i-1]
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long dp[] = new long[n];
        Arrays.fill(dp, 1L);
        for(int i = 1; i<n; i++)
        {
            if( prices[i]+1 == prices[i-1])
                dp[i]+=dp[i-1];
        }
        return Arrays.stream(dp).sum();
    }
}
