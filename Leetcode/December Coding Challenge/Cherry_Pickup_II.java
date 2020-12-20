class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][m];
        int ans = dfs(grid,n,m,0,0,m-1,dp);

        return ans;
    }
    
    int dfs(int[][] grid,int n,int m,int r,int c1,int c2,Integer[][][] dp)
    {
        if(r==n)
            return 0;
        if(dp[r][c1][c2]!=null)
            return dp[r][c1][c2];
        
        int cheries = grid[r][c1] + ((c1==c2)?0:grid[r][c2]);
        
        
        int resultFromNextRow = 0;
        for(int i=-1;i<2;i++)
        {
            for(int j=-1;j<2;j++)
            {
                int nc1 = c1 + i;
                int nc2 = c2 + j;
                if(nc1>=0 && nc1<m && nc2>=0 && nc2<m)
                {
                    resultFromNextRow =Math.max(resultFromNextRow,dfs(grid,n,m,r+1,nc1,nc2,dp));
                
                }
            }
        }
        
        int ans = cheries + resultFromNextRow;
        dp[r][c1][c2] = ans;
        return ans;
        
    }
}