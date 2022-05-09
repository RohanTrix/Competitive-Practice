public class Knight_Probability_in_Chessboard
{
    Double dp[][][];
    int n;
    int dr[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
    int dc[] = { 2, -2, 1, -1, 2, -2, 1, -1 };
    public double favways(int x, int y, int k)
    {
        if(x<0 || x>=n || y<0 || y>=n) return 0;
        if(k == 0) return 1.0;
        if(dp[x][y][k] !=null) return dp[x][y][k];
        double cnt = 0;
        for(int i = 0; i<8; i++)
            cnt+=favways(x+dr[i], y+dc[i], k-1)/8.0; 
        return dp[x][y][k] = cnt;
    }
    public double knightProbability(int N, int k, int row, int column) {
        n = N;
        dp = new Double[N+1][N+1][k+1];
        return favways(row, column, k);
    }
}