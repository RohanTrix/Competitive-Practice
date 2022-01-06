/*
        IDEA: For every cell, if it is a server, then we check
                1) Traversing downwards
                2) Traversing upwards
                3) Traversing rightwards
                4) Traversing leftwards

            If for any of the paths, we get a server, we add 1 to answer to denote current server is
            connected to some server(we don't care which)
*/

public class Count_Servers_that_Communicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for(int i =0;i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j]==0) continue;
                int row1 = i+1;
                int row2 = i-1;
                int col1 = j+1;
                int col2 = j-1;
                boolean f = false;
                while(row1<m) if(grid[row1++][j]==1)f = true;
                while(row2>=0) if(grid[row2--][j]==1)f = true;
                while(col1<n) if(grid[i][col1++]==1)f = true;
                while(col2>=0) if(grid[i][col2--]==1)f=true;
                sum+=f?1:0;
            }
        }
        return sum;
    }
}
