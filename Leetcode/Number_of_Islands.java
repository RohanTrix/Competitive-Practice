class Solution {
    int dr[] = {1,1,0,-1,-1,-1,0,1}; // Trick to traverse a 2D grid
    int dc[] = {0,1,1,1,0,-1,-1,-1}; //
    void recur(int r, int c, char[][] grid, int n,int m)
    {

        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]=='0')
            return;
        grid[r][c] = '0';
        for(int d=0; d<8;d++)
        {
            if(dr[d]==0 || dc[d]==0) // Recur only if direction is not diagnal
                recur(r+dr[d],c+dc[d], grid,n,m);
        }
    }
    public int numIslands(char[][] grid) {
        int ans =0;
        int n = grid.length, m = grid[0].length;
        for( int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {

                    recur(i,j,grid,n,m);
                    ans++;
                }
            
            }
        }
        return ans;
        
        
    }
}