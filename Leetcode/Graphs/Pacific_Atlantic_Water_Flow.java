public class Pacific_Atlantic_Water_Flow
{
    // IDEA : We can mark nodes reachable to Pacific in a 2D array and reachable to Atlantic in another 2d array.
    // Answer will be coordinates from where both are reachable.
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    int mat[][];
    Boolean atlantic[][], pacific[][];
    int m,n;
    public void dfsA(int x, int y) // Marks nodes reachable to atlantic
    {
        if(atlantic[x][y]!=null)
            return;
        
        atlantic[x][y] = true;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i];
            int ny = y+dc[i];
            if(nx<0 || nx>=m || ny<0 || ny>=n || mat[nx][ny] <mat[x][y])
                continue;
            dfsA(nx,ny);
        }
    }
    public void dfsP(int x, int y) // Marks nodes reachable to pacific
    {
        if(pacific[x][y]!=null)
            return;
        
        pacific[x][y] = true;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i];
            int ny = y+dc[i];
            if(nx<0 || nx>=m || ny<0 || ny>=n || mat[nx][ny]<mat[x][y])
                continue;
            dfsP(nx,ny);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        this.mat = mat;
        m = mat.length; n = mat[0].length;
        atlantic = new Boolean[m][n];
        pacific =  new Boolean[m][n];
        for(int i = 0; i<m; i++)
            dfsA(i,n-1);
        for(int i = 0; i<n; i++)
            dfsA(m-1,i);
        for(int i = 0; i<m; i++)
            dfsP(i,0);
        for(int i = 0; i<n; i++)
            dfsP(0,i);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(atlantic[i][j] == null || pacific[i][j] == null)
                    continue;
                if(atlantic[i][j] && pacific[i][j])
                    ans.add(List.of(i,j));
            }
        }
        return ans;
    }
}