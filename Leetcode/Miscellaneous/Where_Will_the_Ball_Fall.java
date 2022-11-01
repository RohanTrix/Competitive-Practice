public class Where_Will_the_Ball_Fall {
    // IDEA : Start a dfs from every cell in the first row, during dfs...we only need to check for successful condition which is:
    //        if we have a leftward slop, then the cell to the left of current (if it exists) should also have a leftward slope
    //        AND if we have a rightward slope, then the cell to the right of current(if it exists) should also have a rightward slope.
    //        Simply make the transition to the next row and adjacent col depending on the slope. If the we reach row end, means
    //        we escape and return column no.
    int grid[][];
    int m, n;
    public int getPos(int x, int y)
    {
        if(y<0 || y>=n) return -1;
        if(x == m) return y;
        
        int ans = -1;
        if(grid[x][y] == 1)
            if(y+1<n && grid[x][y+1] == 1)
                ans = getPos(x+1, y+1);
        else if(y-1>=0 && grid[x][y-1] == -1)
                ans = getPos(x+1, y-1);
        return ans;
    }
    public int[] findBall(int[][] grid) {
        this.grid = grid;
        m = grid.length; n = grid[0].length;
        int ans[] = new int[n];
        for(int i = 0; i<n; i++)
            ans[i] = getPos(0,i);
        return ans;
    }
}
