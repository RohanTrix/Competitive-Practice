public class Count_Unguarded_Cells_in_the_Grid {
    // Idea: For each row and each col, traverse them in both directions maintaining last positions of wall and guard
    public int countUnguarded(int m, int n, int[][] gs, int[][] ws) {
        char grid[][] = new char[m][n];
        for(char g[] : grid) Arrays.fill(g,'E');
        for(int g[] : gs) grid[g[0]][g[1]] = 'G';
        for(int w[] : ws) grid[w[0]][w[1]] = 'W';
        
        // SWEEPING row wise
        for(char row[] : grid)
        {
            int lastG = -1, lastW = -1;
            // For curr row, going left to right
            for(int i=0; i<row.length; i++)
            {
                if(row[i] == 'G')
                    lastG = i;
                else if(row[i] == 'W')
                    lastW = i;
                else
                {
                    if(row[i] == 'B') continue;
                    if(lastG!=-1 && lastG>lastW)
                        row[i] = 'B';
                }
            }
            lastG = n; lastW = n;
            // For curr row, going right to left
            for(int i=row.length-1; i>=0; i--)
            {
                if(row[i] == 'G')
                    lastG = i;
                else if(row[i] == 'W')
                    lastW = i;
                else
                {
                    if(row[i] == 'B') continue;
                    if(lastG!=-1 && lastG<lastW)
                        row[i] = 'B';
                }
            }
        }
        // SWEEPING COL WISE
        for(int j = 0; j<n; j++)
        {
            int lastG = -1, lastW = -1;
            // For curr col, going top to bottom
            for(int i = 0; i<m; i++)
            {
                if(grid[i][j] == 'G')
                    lastG = i;
                else if(grid[i][j] == 'W')
                    lastW = i;
                else
                {
                    if(grid[i][j] == 'B') continue;
                    if(lastG!=-1 && lastG>lastW)
                        grid[i][j] = 'B';
                }
            }
            lastG = m; lastW = m;
            // For curr col, going bottom to top
            for(int i=grid.length-1; i>=0; i--)
            {
                if(grid[i][j] == 'G')
                    lastG = i;
                else if(grid[i][j] == 'W')
                    lastW = i;
                else
                {
                    if(grid[i][j] == 'B') continue;
                    if(lastG!=-1 && lastG<lastW)
                        grid[i][j] = 'B';
                }
            }
            
        }
        int cnt = 0;
        for(char row[] : grid)
        {
            for(char ch : row) if(ch=='E') cnt++;
        }
        return cnt;
    }
}
