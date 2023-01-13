import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// IDEA : The problem can be modelled as a multi-source BFS with 1s as the sources

public class As_Far_from_Land_as_Possible
{
    public int maxDistance(int[][] grid) {
        int INTMAX = Integer.MAX_VALUE/2;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int dist[][] = new int[m][n];
        for(int a[] : dist) Arrays.fill(a, INTMAX);
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(grid[i][j] == 1)
                {
                    q.offer(new int[]{i,j});
                    dist[i][j] = 0;
                }
        int dr[] = {1,0,-1,0,1};
        while(!q.isEmpty())
        {
            int pos[] = q.poll();
            for(int i = 0; i<4; i++)
            {
                int nx = pos[0] + dr[i], ny = pos[1] + dr[i+1];
                if(Math.min(nx, ny)<0 || nx>=m || ny>=n || grid[nx][ny] == 1)
                    continue;
                if(dist[nx][ny] <= 1 + dist[pos[0]][pos[1]])
                    continue;
                
                dist[nx][ny] = 1 + dist[pos[0]][pos[1]];
                q.offer(new int[]{nx,ny});
            }
        }

        int maxi = -1;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<m; j++)
                if(grid[i][j] == 0)
                    maxi = Math.max(maxi, dist[i][j]);
        return maxi==INTMAX?-1:maxi;
    }
}