// Simple DP

// DP STATE : dp[x][y] = Min cost from this cell (x,y) to the bottom.

public class Minimum_Falling_Path_Sum {
    int m,n;
    Integer dp[][];
    public int minSum(int x, int y, int grid[][])
    {
        if(y<0 || y>=n) return Integer.MAX_VALUE/2;
        if(x == m) return 0;
        if(dp[x][y] != null) return dp[x][y];
        
        return dp[x][y] = grid[x][y] + Math.min(minSum(x+1, y, grid), Math.min(minSum(x+1, y-1, grid), minSum(x+1, y+1, grid)));
    }
    public int minFallingPathSum(int[][] grid) {
        m = grid.length; n = grid[0].length;
        dp = new Integer[m][n];
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++)
            mini = Math.min(mini, minSum(0,j, grid));
        return mini;
    }
}
