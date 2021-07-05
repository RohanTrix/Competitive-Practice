package Leetcode.Miscellaneous;
import java.util.*;
public class Island_Perimeter {
    HashSet<Integer> hs = new HashSet<>();
    int dr[] = {1,0,0,-1};
    int dc[] = {0,-1,1,0};
    int ans = 0;
    public void dfs(int grid[][], int r, int c)
    {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0)
        {
            ans++;
            return;
        }
        if(grid[r][c]==2) return;
        grid[r][c] = 2; // Represents cell is visited
        for( int i =0; i < 4; ++i)
        {
            dfs(grid, r + dr[i], c+ dc[i]);
        }
        
    }
    public int islandPerimeter(int[][] grid) {
        for( int i =0 ; i<grid.length; ++i)
        {
            for( int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid, i, j);
                    return ans;
                }
            }
        }
        return ans;
    }
}
