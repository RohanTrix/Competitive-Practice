/*
 *      IDEA : Looking at the constraints will give the hint to use a bitmask to remember which cells we have taken or not taken
 *             We can encode a 2D cell of a matrix into a single value using ( r*C + c ) logic. 
 *             The final state of the mask will be all cells picked apart from the obstacles cells. 
 *             Apart from that, we just have to do a DFS on the matrix and use it to count the number of paths that end at END cell
 *             with FULLMASK.
 */
public class Unique_Paths_III
{
    int m,n, FULLMASK;
    int dr[] = {1,0,-1,0,1};
    int grid[][];
    public int encode(int x, int y)
    {
        return x*n+y;
    }
    public int dfs(int x, int y, int mask)
    {
        if(Math.min(x,y)<0 || x>=m || y>=n || grid[x][y] == -1)
            return 0;
        if( (mask&(1<<encode(x,y))) != 0)
            return 0;
        mask|=(1<<encode(x,y));
        if(grid[x][y] == 2)
            return mask == FULLMASK?1:0;
        int cnt = 0;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i], ny = y+dr[i+1];
            cnt+=dfs(nx, ny, mask);
        }
        return cnt;
    }
    public int uniquePathsIII(int[][] g) {
        this.grid = g;
        m = grid.length; n = grid[0].length;
        FULLMASK = 0;
        int sx = 0, sy = 0;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] != -1)
                    FULLMASK|=(1<<encode(i,j));
                if(grid[i][j] == 1)
                {sx = i; sy = j;}
            }
        
        return dfs(sx,sy, 0);
        
    }
}