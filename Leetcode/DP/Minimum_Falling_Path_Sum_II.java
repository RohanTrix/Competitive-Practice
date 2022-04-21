/*
    IDEA : We basically have to select a cell in each row such that no two cols are same between adjacent rows.

           * So it is clear to observe that, the next cell we pick is based on the cell we are at currently at.
             Thus, we want to store what is the minimum cost we get when we are at (x,y) with some col j chosen previously.
             But this will be a little naive, as at any row, we want to take the minimum value among all which is not in col j.

             So it is enough to store current row and previous column.

             DP STATE : dp[i][prevCol] =  Minimum Sum from row i to bottom row when column j is blocked.

             DP TRANS: dp[i][prevCol]  = MIN( dp[i+1][j] + grid[i][j]) for all j except j=prevCol

*/
public class Minimum_Falling_Path_Sum_II {
    Integer dp[][];
    int m, n;
    public int minSum(int i, int prevCol, int grid[][])
    {
        if(i == m) return 0;
        if(dp[i][prevCol] !=null) return dp[i][prevCol];
        
        int mini = Integer.MAX_VALUE/2;
        for(int j = 0; j<n; j++)
        {
            if(j == prevCol) continue;
            mini = Math.min(mini, minSum(i+1, j, grid) + grid[i][j]);
        }
        return dp[i][prevCol] = mini;
    }
    public int minFallingPathSum(int[][] grid) {
        m = grid.length; n = grid[0].length;
        dp = new Integer[m][n+1];
        return minSum(0, n, grid);
    }
}
