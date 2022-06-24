public class Number_of_Longest_Increasing_Subsequence
{
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n]; // dp[i] = Length of longest increasing subseq ending at ith
        int cnt[] = new int[n]; // cnt[i] = Count of longest increasing subsequences ending at ith
        Arrays.fill(cnt, 1);
        Arrays.fill(dp, 1);
        int maxLen = -1;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[j]+1>dp[i]) // If a higher max length is achieved, then reset the count to the jth element's count.
                    {
                        cnt[i] = cnt[j];
                        dp[i] = dp[j]+1;
                    }
                    else if(dp[j]+1 == dp[i]) // If same highest length is acheived...and to the current count.
                        cnt[i]+=cnt[j];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int count = 0;
        for(int i = 0; i<n; i++)
            if(maxLen == dp[i]) // Accumulate count of values where maxLen is acheived.
                count+=cnt[i];
        return count;
    }
}