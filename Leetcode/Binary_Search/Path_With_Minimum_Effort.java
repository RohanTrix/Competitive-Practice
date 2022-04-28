/*
    IDEA : Looking at the problem, we know that if we consider some value to be the maximum effort(or max abs diff), then every other
           diff in the path should be <= to this max effort. Hence, this makes the maximum effort value binary searchable. And on top of that,
           since our starting point is always fixed at (0,0), we can use a DFS to find out if we can reach (m-1, n-1).
           We keep a variable prev in dfs to help calculating the diff in heights between current and the node it came from.
           If this diff is larger than our currently chosen threshold, then we will dicard this path.

           The binary searchable property for this is that:
            -> If I can reach (m-1, n-1) with threshold `thresh`, then surely I can reach (m-,n-1) with threshold [thresh+1.....INF].
               So I can look for a smaller threshold.
               Else, I need to increase my threshold to get a good path.

*/
public class Path_With_Minimum_Effort
{
    int dr[] = {1,-1,0,0}, dc[] = {0,0,1,-1};
    int m, n;
    int thresh;
    boolean vis[][];
    public boolean dfs(int x, int y, int grid[][], int prev)
    {
        if(x<0 || y<0 || x>=m || y>=n || vis[x][y] || Math.abs(grid[x][y]-prev)>thresh)
            return false;
        if(x==m-1 && y == n-1) return true;
        boolean ans = false;
        vis[x][y] = true;
        for(int p = 0; p<4; p++)
        {
            int nx = x+dr[p], ny = y+dc[p];
            ans = ans || dfs(nx,ny, grid, grid[x][y]);
        }
        return ans;
    }
    public int minimumEffortPath(int[][] grid) {
        int left = 0, right = (int)1e6;
        int ans = -1;
        m = grid.length; n = grid[0].length;
        vis = new boolean[m][n];
        while(left<=right)
        {
            thresh  = left + (right - left)/2;
            if(dfs(0,0, grid, grid[0][0]))
            {
                ans = thresh;
                right = thresh - 1;
            }
            else
                left = thresh + 1;
            
            for(boolean a[]: vis) Arrays.fill(a, false);
        }
        return ans;
    }
}