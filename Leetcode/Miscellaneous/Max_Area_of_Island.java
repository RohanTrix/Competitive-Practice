class Solution {
    int dr[] = {1,1,0,-1,-1,-1,0,1};
    int dc[] = {0,1,1,1,0,-1,-1,-1};
    int ans = 0;
    void recur(int r, int c, int[][] grid, int n,int m)
    {
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==0)
            return;
        grid[r][c] = 0;
        ans++;
        for(int d=0; d<8;d++)
        {
            if(dr[d]==0 || dc[d]==0)
                recur(r+dr[d],c+dc[d], grid,n,m);
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length, m = grid[0].length, finAns = 0;
        for( int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    ans =0;
                    recur(i,j,grid,n,m);
                    finAns = Math.max(finAns, ans);
                }
            
            }
        }
        return finAns;
        
        
    }
}