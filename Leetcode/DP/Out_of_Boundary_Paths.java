class Solution
{
    Long dp[][][]; // dp[x][y][maxMoves];
    int mod = (int)1e9+7;
    int dr[] = {1,0,-1,0,1};
    public long count(int x, int y, int maxMove, int m, int n)
    {
        if(Math.min(x,y)<0 || x>=m || y>=n) return 1;
        if(dp[x][y][maxMove] != null) return dp[x][y][maxMove];
        long cnt = 0;
        for(int i = 0; i<4; i++)
        {
            int nx = x+dr[i], ny = y+dr[i+1];
            if(maxMove>0) 
            {
                cnt+=count(nx,ny, maxMove-1,m,n);
                cnt%=mod;
            }
        }
        return dp[x][y][maxMove] = cnt;
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m][n][maxMove+1];
        return (int) count(startRow, startColumn, maxMove, m,n);
    }
}