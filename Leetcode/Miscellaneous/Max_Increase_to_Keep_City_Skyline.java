/*
        IDEA: We can observe if we are to increase the height of any building, it should not
              cross the max height building of that its row as well as column.

              Hence we should first compute the max in each row and each coloumn separetly.
        
              Now, we traverse on each building, and increase its height upto the minimum of
              (max of its column) and (max of its row). By taking minimum, we ensure it doesn't cross
              either building.

        Problem solved by self in one go!
*/

public class Max_Increase_to_Keep_City_Skyline
{
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxRow[] = new int[n];
        int maxCol[] = new int[m];

        for(int i = 0;i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int maxSum = 0;
        for(int i = 0;i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                maxSum+=Math.min(maxRow[i],maxCol[j]) - grid[i][j];
            }
        }
        return maxSum;
    }
}