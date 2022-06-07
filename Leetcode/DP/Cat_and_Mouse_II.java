public class Cat_and_Mouse_II
{
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    int catJump, mouseJump;
    Boolean dp[][][][][];
    
    public boolean inBound(int x, int y, char grid[][])
    {
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }

    public boolean isWinner(int x1, int y1, int x2, int y2, int moves, char grid[][])
    {
        // System.out.println(x1+" "+y1+" "+x2+" "+y2);
        if(moves>100)
            return false;
        if(x1 == x2 && y1 == y2)
            return false;
        if(grid[x1][y1] == 'F')
            return true;
        if(grid[x2][y2] == 'F')
            return false;
        if(dp[x1][y1][x2][y2][moves]!=null) return dp[x1][y1][x2][y2][moves];
        if(moves%2 == 0)
        {
            for(int i = 0; i<4; i++)
            {
                for(int j = 0; j<=mouseJump; j++)
                {
                    int nx1 = x1 + (dr[i]*j), ny1 = y1 + (dc[i]*j);
                    if(inBound(nx1, ny1, grid) && grid[nx1][ny1] != '#')
                    {
                        if(isWinner(nx1, ny1, x2, y2, moves+1, grid))
                            return dp[x1][y1][x2][y2][moves] = true;
                    }
                    else break;
                }
            }
            return dp[x1][y1][x2][y2][moves] = false;
        }
        else
        {
            for(int i = 0; i<4; i++)
            {
                for(int j = 0;j<=catJump; j++)
                {
                    int nx2 = x2 + (dr[i]*j), ny2 = y2 + (dc[i]*j);
                    if(inBound(nx2, ny2, grid) && grid[nx2][ny2] != '#')
                    {
                        if(!isWinner(x1,y1, nx2, ny2, moves+1, grid))
                            return dp[x1][y1][x2][y2][moves] = false;
                    }
                    else break;
                }
            }
            return dp[x1][y1][x2][y2][moves] = true;
        }
    }
    public boolean canMouseWin(String[] g, int catJump, int mouseJump) {
        this.catJump = catJump;
        this.mouseJump = mouseJump;
        char grid[][] = new char[g.length][g[0].length()];
        for(int i = 0; i<g.length; i++)
            grid[i] = g[i].toCharArray();
        // System.out.println(Arrays.deepToString(grid));
        dp = new Boolean[8][8][8][8][101];
        int x1=0,y1=0,x2=0,y2=0;
        for(int i = 0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 'M')
                {
                    x1 = i; y1 = j;
                }
                if(grid[i][j] == 'C')
                {
                    x2 = i; y2 = j;
                }
            }
        return isWinner(x1,y1,x2,y2, 0, grid);
    }
}