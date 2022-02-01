public class Number_of_Enclaves
{
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,1,-1};
    int m, n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i==0 || i==m-1 || j==0 || j==n-1)
                    dfs(i,j,grid);
            }
        }
        for(int i =0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
                cnt+=grid[i][j];
        }
        return cnt;
        
    }
    public void dfs(int x, int y, int grid[][])
    {
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0)return;
        grid[x][y] = 0;
        
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i], ny = y+dc[i];
            dfs(nx, ny, grid);
        }
    }
}