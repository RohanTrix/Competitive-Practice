/*
        IDEA:
            Apart from this being a DP problem, the only trick part is the time and space constraints.
            A naive DP STATE would be:
                dp[i][j][m] = Max score one can get for array nums[i..j] on mth iteration
            
            However, this will easily TLE as its O(n*n*m) or MLE.
            The special constaint on m of 10^3 suggests we need a O(m^2) approach. This can be acheived by
            deriving i or j from m.

            Since for m = 0, j-i = n-1
            we can form the relation:
                                        (i+1) denotes the 
                                      ==> right = (n-1) - (i - left)
            
            DP TRANSITIONS:

                dp[i][m] = max(nums[i] * mul[m] + dp[i + 1][m + 1],
                               nums[j] * mul[m] + dp[i][m + 1]
                               )
            
*/
class Maximum_Score_from_Performing_Multiplication_Operations {
    Integer dp[][];
    int nums[], muls[];
    public int maxScore(int left, int i)
    {
        if(i == muls.length) return 0;
        if(dp[left][i]!=null) return dp[left][i];
        
        int right = nums.length - 1 - (i - left);
        
        int ch1 = muls[i]*nums[left] + maxScore(left+1, i+1);
        int ch2 = muls[i]*nums[right]+ maxScore(left, i+1);
        return dp[left][i] = Math.max(ch1, ch2);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums; this.muls = multipliers;
        int m = multipliers.length;
        dp = new Integer[m+1][m+1];
        return maxScore(0, 0);
    }
}
