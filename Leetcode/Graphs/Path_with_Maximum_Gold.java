public class Path_with_Maximum_Gold {
    boolean vis[][];
    int dr[] = {1,-1,0,0};
    int dc[] = {0,0,-1,1};
    public int dfs(int x, int y, int grid[][])
    {
        if(grid[x][y]==0) return 0;
        int m = grid.length, n = grid[0].length;
        int maxi = 0;
        int currVal = grid[x][y];
        grid[x][y] = 0;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i],ny = y+dc[i];
            if(nx<0||nx>=m||ny<0||ny>=n ||grid[nx][ny]==0) continue;
            
            maxi = Math.max(maxi, dfs(nx,ny,grid));
        }
        grid[x][y] = currVal;
        return maxi+currVal;
    }
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
       
        
        int maxi = 0;
        for(int i =0; i<m; i++){
            
            for(int j = 0; j<n; j++)
            {
                maxi = Math.max(maxi, dfs(i,j,grid));
            }
        }
                
        return maxi;
    }
}