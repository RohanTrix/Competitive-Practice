/*  IDEA:
        We keep track of the positions of both the robots, and find the answer using DP.

        DP STATE:
                dp[r1][c1][r2][c2] = Max cherries collected by robots starting from 
                (r1,c1) and (r2,c2).

        DP TRANSITION:

                MAX of dp by going in all 3 directions downwards. If the two robots end up at same place,
                we add cherries of their coordinates only once or else add cherries from both coordinates.
                For a clearer picture, solve Cherry Pickup 1 first.
*/
public class Cherry_Pickup_II {
    int dp[][][][];
    int dc[] = {-1,0,1};
    // Determines if we are out of bounds or not
    public boolean posValid(int r, int c, int grid[][])
    {
        int m = grid.length;
        int n = grid[0].length;
        return r>=0&&r<m&&c>=0&&c<n;
    }
    public int getSum(int r1, int c1, int r2, int c2, int[][] grid)
    {
        if(dp[r1][c1][r2][c2]!=-1) return dp[r1][c1][r2][c2];
        int ans = 0;
        // We take all possibilities of both robots moving which 3*3
        for(int i = 0; i<3; i++)
        {
            int nr1 = r1+1;int nc1 = c1+dc[i];

            if(!posValid(nr1,nc1,grid)) continue;
            for(int j = 0; j<3;j++)
            {
                int nr2 = r2+1;int nc2 = c2+dc[j];
                if(!posValid(nr2,nc2,grid)) continue;
                
                // Get max sum from all transitions from nextRow
                ans = Math.max(ans, getSum(nr1,nc1, nr2, nc2, grid));
            }
        }
        if(r1==r2 && c1==c2) return dp[r1][c1][r2][c2] = grid[r1][c1] + ans;
        return dp[r1][c1][r2][c2] = grid[r1][c1] + grid[r2][c2] + ans;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][m][n];
        for(int a[][][]:dp)
            for(int b[][]:a)
                for(int c[]: b) Arrays.fill(c,-1);
        
        int ans = getSum(0,0,0,n-1, grid);
        return ans;
    }
}
