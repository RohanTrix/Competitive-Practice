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
                                         m = (n-1) - (j - i)
                                      ==> j = (n-1) + (i - m)
            
            DP TRANSITIONS:

                dp[i][m] = max(nums[i] * mul[m] + dp[i + 1][m + 1],
                               nums[j] * mul[m] + dp[i][m + 1]
                               )
            
*/
class Maximum_Score_from_Performing_Multiplication_Operations {
    int mul[];
    int dp[][];

    public int maxScore(int nums[], int i, int m) {
        if (m == mul.length)
            return 0;
        if (dp[i][m] != -1)
            return dp[i][m];
        int j = nums.length - 1 + (i - m);
        int left = nums[i] * mul[m] + maxScore(nums, i + 1, m + 1);
        int right = nums[j] * mul[m] + maxScore(nums, i, m + 1);
        return dp[i][m] = Math.max(left, right);

    }

    public int maximumScore(int[] nums, int[] multipliers) {
        mul = multipliers;
        dp = new int[mul.length][mul.length];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return maxScore(nums, 0, 0);
    }
}
