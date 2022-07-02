public class Longest_Arithmetic_Subsequence
{
    // IDEA: LIS type O(n2) dp with DP STATE : dp[i][d] = Longest subseq ending at i with common diff = d
    //       Since we can have a min common diff of -500...
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][1000+5];
        int maxi = 1;
        for(int a[] : dp) Arrays.fill(a, 1);
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d]+1);
                maxi = Math.max(maxi, dp[i][d]);
            }
        }
        return maxi;
    }
}