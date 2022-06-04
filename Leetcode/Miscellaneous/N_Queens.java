public class N_Queens
{
    List<List<String>> configs = new ArrayList<>();
    int dr[] = {1,1,-1,-1};
    int dc[] = {-1,1,-1,1};
    // Checks if cell is within bounds
    public boolean withinBound(int x, int y, int m, int n)
    {
        return x>=0 && y>=0 && x<m && y<n;
    }
    // Checks if the 4 diagnol directions from a cell are free and not attacked by another 
    public boolean checkDiagnolFree(int row, int col, char board[][])
    {
        boolean ans = true;
        outer:
        for(int p = 0; p<4; p++)
        {
            int x = row, y = col;
            while(withinBound(x,y,board.length, board[0].length))
            {
                ans = ans && (board[x][y] == '.');
                if(!ans) break outer;
                x+=dr[p]; y+=dc[p];
            }
        }
        return ans;
    }
    public void recur(int rownum, int colmask, char board[][])
    {
        if(rownum == board.length)
        {
            List<String> curr = new ArrayList<>();
            for(char arr[] : board) curr.add(new String(arr));
            configs.add(curr);
            return;
        }
        for(int i = 0; i<board[0].length; i++)
        {
            if((colmask&(1<<i))!=0) continue;
            if(!checkDiagnolFree(rownum,i, board)) continue;
            board[rownum][i] = 'Q';

            recur(rownum+1, colmask|(1<<i), board);
            board[rownum][i] = '.';
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(char a[] : board) 
            Arrays.fill(a, '.');
        recur(0, 0, board);
        return configs;
    }
}