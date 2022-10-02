public class Maximum_Sum_of_an_Hourglass {
    // Brute force
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long maxi = Long.MIN_VALUE;
        for(int x1 = 0; x1<m-2; x1++)
        {
            for(int y1 = 0; y1<n-2; y1++)
            {
                int x2 = x1+2, y2 = y1+2;
                long sum = 0;
                for(int i = x1; i<=x2; i++)
                    for(int j = y1; j<=y2; j++)
                        sum+=grid[i][j];
                sum-=(grid[x1+1][y1] + grid[x2-1][y2]);
                maxi = Math.max(maxi, sum);
            }
        }
        return (int)maxi;
    }
}
