public class Cherry_Pickup {
    // Refer DP Tricks Notes
    // Refer https://youtu.be/x_U3dJhPdlE     if Notes not helpful

    int dp[][][][];
    int INT_MIN = Integer.MIN_VALUE/2;

    // Returns the best sum when P1 lands on (r1,c1) and P2 lands on (r2, c2)
    public int bestSum(int grid[][],int r1, int c1, int r2, int c2)
    {
        // If a transition is out of bounds or a thorn, we send large negative value
        if(r1<0 || c1<0 || r2<0 || c2<0 || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return INT_MIN;
        
        // Return DP value if value set in table
        if(dp[r1][c1][r2][c2]!=INT_MIN)return dp[r1][c1][r2][c2];


        // Stores the cherries picked in this state only
        int gainHere = 0;
        if(r1==r2 && c1 == c2) gainHere +=grid[r1][c1]; // If both players arrive on same cell

        else gainHere += grid[r1][c1]+grid[r2][c2]; // If both players arrive on different cells
        
        // Direction Vectors 
        int dir[][] = {{0,1},{1,0}};

        int bestPrevState = INT_MIN;
        
        // Nested loop gives us the 4 combinations of moves discussed
        for(int p1[]:dir)
        {
           for(int p2[]:dir)
           {
               // Forming cell coordinates from which we can come to current state
               int nr1 = r1 - p1[0];
               int nc1 = c1 - p1[1];
               int nr2 = r2 - p2[0];
               int nc2 = c2 - p2[1];
               
               // Taking the best answer from 4 possibilities
               bestPrevState = Math.max(bestPrevState, bestSum(grid,nr1,nc1,nr2,nc2));
           }
        }
        // Return best sum from one of previous states and cherries gained here
        return dp[r1][c1][r2][c2] = bestPrevState + gainHere;
            
        
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n][n];
        for(int a[][][]:dp)
            for(int b[][]:a)
                for(int c[]:b)
                    Arrays.fill(c, INT_MIN);
        
        // Since game starts in cell (0,0), only one person has picked the cherry
        dp[0][0][0][0] = grid[0][0];
        // Return best answer but return 0 if no path was possible resulting in INT_MIN
        return Math.max(bestSum(grid, n-1,n-1,n-1,n-1),0);
    }
}
