package Leetcode.DP;

// Check Youtube for explanation, Tricky Problem

public class Dungeon_Game {
    int dp[][];
    int m, n;
    // dp[i][j] = Min Health req top reach from (i,j) to end
    public int calculateMinimumHP(int[][] dun) {
        m = dun.length; n = dun[0].length;
        dp = new int[m+1][n+1];
        for(int a[]: dp) Arrays.fill(a, Integer.MAX_VALUE);
        for(int i = m-1;i>=0; i--)
        {
            for(int j = n-1; j>=0; j--)
           {
                if(i == m-1 && j == n-1) dp[i][j] = Math.max(1, 1-dun[i][j]);
                else dp[i][j] = Math.max(1,Math.min(dp[i+1][j],dp[i][j+1]) - dun[i][j]);
            }
        }
        return dp[0][0];
    }
}
