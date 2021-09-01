package Leetcode.DP;

public class Unique_Paths_II
{
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length, n = obs[0].length;
        int dp[][] = new int[m][n];
        
        if(obs[0][0]!=1)dp[0][0] = 1;
        for(int i =0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(obs[i][j]==1)continue;
                if((i-1)>=0 && obs[i-1][j]!=1)dp[i][j]+=dp[i-1][j];
                if((j-1)>=0 && obs[i][j-1]!=1)dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}