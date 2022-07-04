/**
 *      PREREQ => LC QUES : Longest Increasing Path in a Matrix
 *      IDEA:
 *             DP STATE : DP[x][y] = No. of strictly increasing paths starting from (x,y)
 *             DP TRANS : DP[x][y] = 1 + SUM( No. of inc paths from its valid neighbours)
 *          
 *             valid neighbours means a neighbour which is inside bounds and has a value greater than current cell's value
 * 
 */
public class Number_of_Increasing_Paths_in_a_Grid {
    int dr[] = { 0, 0, 1, -1 };
    int dc[] = { 1, -1, 0, 0 };
    int m, n, mod = (int) 1e9 + 7;
    Long dp[][];

    public long dfs(int x, int y, int grid[][]) {
        if (dp[x][y] != null)
            return dp[x][y];
        dp[x][y] = 1L;
        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i], ny = y + dc[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] <= grid[x][y])
                continue;
            dp[x][y] += dfs(nx, ny, grid);
            dp[x][y] %= mod;
        }
        return dp[x][y];
    }

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Long[m][n]; // dp[x][y] = No. of strictly inc path originating from (x,y)
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dfs(i, j, grid);
        long cnt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                cnt += dp[i][j];
                cnt %= mod;
            }
        return (int) cnt;
    }
}
