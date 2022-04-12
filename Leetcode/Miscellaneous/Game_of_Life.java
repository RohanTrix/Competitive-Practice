public class Game_of_Life {
    // To make constant space: Use the following notation to denote new states
    // 2 denotes ---- 0 -> 1
    // 3 denotes ---- 1 -> 0

    // These mean that if we go from 0 to 1, so its original value was 0 and new value will be 1
    // This will be useful while processing the new value for each cell
    public int checkLive(int x, int y, int board[][])
    {
        if(x<0 || y<0 || x>=board.length || y>=board[0].length)
            return 0;
        if(board[x][y] == 1 || board[x][y] == 3) return 1;
        return 0;
    }
    public void gameOfLife(int[][] board) {
        
        int dr[] = {0,0,1,1,1,-1,-1,-1};
        int dc[] = {1,-1,0,1,-1,0,1,-1};
        int m = board.length, n = board[0].length;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                int neighbour_cnt = 0;
                for(int p = 0; p<8; p++)
                    neighbour_cnt+=checkLive(i+dr[p], j+dc[p], board);
                //System.out.print(neighbour_cnt+" ");
                if(board[i][j] == 1)
                    if(neighbour_cnt<2 || neighbour_cnt>3)
                        board[i][j] = 3;
                if(board[i][j] == 0)
                    if(neighbour_cnt==3)
                        board[i][j] = 2;
            }
            //System.out.println();
        }
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }
}
