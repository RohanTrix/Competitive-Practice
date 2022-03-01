/*
        IDEA : This looks like a DP problem SINCE u have a choice,whether or not to use the current element
               and if u do use, then also you have a choice of using it as a odd ending or even ending 
               positioned element.

            DP STATE:
                dp[i][0] = Maximum alterating sum of subsequence ending at i as a even value;
                dp[i][1] = Maximum alternating sum of subsequence ending at i as a odd value;
            
            DP TRANSITION:
                Simply written in code
*/
public class Maximum_Alternating_Subsequence_Sum
{
    public long maxAlternatingSum(int[] nums) {
        
        long dp[][] = new long[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        long finAns = nums[0];
        for(int i = 1; i<nums.length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][1] + nums[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] - nums[i], dp[i-1][1]);
            
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}