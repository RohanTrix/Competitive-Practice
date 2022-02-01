/*  
        IDEA: Since the islands connected to the boundary cells will not be a closed island,
              we call a dfs from each boundary cell which will mark each '0' cell connected to the boundary as
              a '1' cell. 
              
              Now, the only islands left are the ones which were not connected to the boundary.
              This is simply finding the number of connected components in a graph. And this no.
              of components is our answer.
*/

public class Number_of_Closed_Islands
{
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    int m , n;
    public void dfs(int x, int y, int grid[][])
    {
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 1) return;
        
        grid[x][y] = 1;
        
        for(int i =0; i<4; i++)
        {
            int nx = x+dr[i], ny = y+dc[i];
            dfs(nx,ny,grid);
        }
    }
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i<m ; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                {
                    dfs(i,j,grid);
                }
            }
        }
        for(int i = 0; i<m ; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    cnt++;
                    dfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
}