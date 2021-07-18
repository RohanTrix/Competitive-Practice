package Leetcode.Miscellaneous;

import java.util.*;

// Mark array (copy of board intially) is created to mark all nodes on or connected to the boundary cells of the matrix. Finally, only
// the values marked with 'O' in the mark array are converted to 'X' in the main array as these
// were not connected to the edge and got filled with water.
public class Surrounded_Regions {
    int dr[] = {1,0,-1,0};
    int dc[] = {0,1,0,-1};
    public void dfs(char[][] mark, int i , int j)
    {
        if(i<0 || i>=mark.length || j<0 || j>=mark[0].length || mark[i][j]!='O')
            return;
        mark[i][j] = 'M';
        
        for(int p = 0; p<4; p++)
        {
            dfs(mark, i+dr[p], j+dc[p]);
        }
    }
    public void solve(char[][] board) {
        char[][] mark = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
        int n = board.length;
        int m = board[0].length;
        for(int i =0; i<m;i++)
        {
            if(board[0][i]=='O')
                dfs(mark, 0, i);
        }
        for(int i =0; i<n;i++)
        {
            if(board[i][m-1]=='O')
                dfs(mark, i, m-1);
        }
        for(int i =m-1; i>=0;i--)
        {
            if(board[n-1][i]=='O')
                dfs(mark, n-1, i);
        }
        for(int i =n-1; i>=0;i--)
        {
            if(board[i][0]=='O')
                dfs(mark, i, 0);
        }
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(mark[i][j]=='O')board[i][j]='X';
                
            }
        }
        
    }
}
