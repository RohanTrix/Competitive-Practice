package Leetcode.DP;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings {
    // Variant of Edit Distance/ LCS
    public int minimumDeleteSum(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 1; i<=m; ++i)dp[i][0]= dp[i-1][0]+ (int) w1.charAt(i-1);
        for(int i = 1; i<=n; ++i)dp[0][i] = dp[0][i-1]+ (int) w2.charAt(i-1);
        for(int i = 1; i<=m; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                if(w1.charAt(i-1)==w2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(
                    (int)w2.charAt(j-1) + dp[i][j - 1],
                    (int)w1.charAt(i-1) + dp[i - 1][j]
                                        
                                        );
                
            }
        }
        return dp[m][n];
    }
}
