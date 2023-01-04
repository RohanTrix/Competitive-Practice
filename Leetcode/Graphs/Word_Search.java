/*
    IDEA: Perform a DFS from every cell, trying to place the ith character. If ith char matches with the cell, explore
          this node futher or return 

*/
import java.util.*;
public class Word_Search {
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    int m,n;
    String s;
    public boolean dfs(int x, int y, char board[][], int i)
    {
        if(i==s.length())return true;
        if(x<0 || x>=m || y<0 || y>=n || board[x][y]!=s.charAt(i)) return false;
        
        //System.out.println(board[x][y]);
        char orig = board[x][y];
        board[x][y] = '#';
        boolean ans = false;
        for(int p = 0; p<4; p++)
        {
            int nx = x+dr[p], ny = y + dc[p];
            ans = ans || dfs(nx, ny, board, i+1);
        }
        
        board[x][y] = orig;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        s = word;
        m = board.length;
        n = board[0].length;
        boolean ans = false;
        for(int i = 0; i<m; i++)
            for(int j = 0;j<n; j++)
                ans = ans || dfs(i,j,board, 0);
        return ans;
    }
}
