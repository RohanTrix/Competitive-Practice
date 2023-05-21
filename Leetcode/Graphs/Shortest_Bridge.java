import java.util.LinkedList;
import java.util.Queue;

/**
 *      IDEA : First of all it is important to distinguish the 2 islands, so we use to make any one of the
 *             islands marked by 2 instead of 1. Now, question asks for converting the shortest number of
 *             cells to connect to the other island. The shortest path from a 2 marked island to a originally
 *             1 marked island will be equal to 1+ the number of cells to toggle. So it is better to find the shortest
 *             path. But shortest path from where since we have multiple starting points? This is classic scenario
 *             for utilising Multi Source BFS. The first time when we encounter a 1 marked cell will surely be
 *             (one of the) shortest path in teh BFS.
 * 
 */

public class Shortest_Bridge {
    int grid[][];
    int m,n;
    Queue<int[]> q;
    Integer dist[][];
    int dr[] = {0,1,0,-1,0};
    public void dfs(int x, int y) {
        if(Math.min(x, y)<0 || x>=m || y>=n || grid[x][y]!=1) return;
        grid[x][y] = 2;
        q.offer(new int[]{x,y});
        dist[x][y] = 0;
        for(int i = 0; i<4; i++){
            dfs(x+dr[i], y+ dr[i+1]);
        }
    }
    public void markOtherIsland() {
        
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(grid[i][j] == 1) {
                    dfs(i,j);
                    return;
                }
    }
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        m = grid.length; n = grid[0].length;
        q = new LinkedList<>();
        dist = new Integer[m][n];
        markOtherIsland();  
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int curr[] = q.poll();

            if(grid[curr[0]][curr[1]] == 1){
                ans = dist[curr[0]][curr[1]];
                break;
            }
            for(int i = 0; i<4; i++) {
                int nx = curr[0] + dr[i], ny = curr[1]+dr[i+1];
                if(Math.min(nx, ny)<0 || nx>=m || ny>=n || dist[nx][ny]!=null)
                    continue;

                q.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[curr[0]][curr[1]]+1;
            }
        }
        return ans - 1;
    }
}