
import java.util.*;
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        int n  = grid.length;
        int m = grid[0].length;
        for(int arr[] : dp)
            Arrays.fill(arr, Integer.MAX_VALUE/2);
        dp[0][0] = grid[0][0];
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(i==0 && j==0) continue;
                if(i>0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                if(j>0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                dp[i][j]+=grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
