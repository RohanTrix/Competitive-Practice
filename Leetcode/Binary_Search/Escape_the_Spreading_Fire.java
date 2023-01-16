package Leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    IDEA : Multi source BFS needed for the fires...but if we BFS the man along with the fires, by adding the
           man at the correct level, code faces a lot of minor errors(lot of WAs on this).

           First, we build a time matrix which stores the shortest time it takes for a fire to reach
           a cell.

           Next, we binary search on the waiting time. For every mid, we insert into the queue the positions
           and the starting time as mid. Then, we check if at any point the man arrives at a cell
           with fire's time lower, then we cannot reach the last cell. One edge case to be kept in mind
           is that for the last cell, the arrival time of the man and the fire time can be equal.

*/
public class Escape_the_Spreading_Fire {
    int m, n;
    int dr[] = {0,0,-1,1};
    int dc[] = {1,-1,0,0};
    int time[][];
    public void spreadFire(int g[][], List<int[]> fires)
    {
        int grid[][] = new int[m][n];
        for(int i = 0; i<m; i++) grid[i] = g[i].clone();
        Queue<int[]> q = new LinkedList<>();
        for(int arr[] : time) Arrays.fill(arr, Integer.MAX_VALUE/2);
        for(int arr[] : fires)
        {
            q.offer(new int[]{arr[0], arr[1]});
            time[arr[0]][arr[1]] = 0;
        }
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                int pos[] = q.poll();
                for(int d = 0; d<4; d++)
                {
                    int nx = pos[0]+dr[d], ny = pos[1]+dc[d];
                    if (nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny] == 2) continue;
                    grid[nx][ny] = 2;
                    time[nx][ny] = time[pos[0]][pos[1]] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        
    }
    public boolean possible(int mid, int g[][], List<int[]> fires)
    {
        int grid[][] = new int[m][n];
        
        for(int i = 0; i<m; i++) grid[i] = g[i].clone();
        Queue<int[]> q = new LinkedList<>();
        if(time[0][0]>mid) q.offer(new int[]{0,0,mid});        
        
        while(!q.isEmpty())
        {            
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                int pos[] = q.poll();
                // System.out.print(Arrays.toString(pos)+" ");
                if(pos[0] == m-1 && pos[1] == n-1 && pos[2]<=time[m-1][n-1])
                    return true;
                
                if(pos[2]>=time[pos[0]][pos[1]]) continue;
                for(int d = 0; d<4; d++)
                {
                    int nx = pos[0]+dr[d], ny = pos[1]+dc[d];
                    if (nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny] == 2) continue;
                    grid[nx][ny] = 2;
                    q.add(new int[]{nx,ny, pos[2]+1});
                }
            }
            // System.out.println();
        }
        return false;
    }
    public int maximumMinutes(int[][] grid) {
        int ans = -1;
        int left = 0, right = (int)1e9;
        m = grid.length; n = grid[0].length;
        time = new int[m][n];
        
        List<int[]> fires = new ArrayList<>();
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    fires.add(new int[]{i,j});
                    grid[i][j] = 2;
                }
            }
        }
        spreadFire(grid, fires);

        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(possible(mid, grid, fires))
            {
                ans = mid;
                left = mid + 1;
                
            }
            else right = mid - 1;
        }
        return ans;
    }
}
