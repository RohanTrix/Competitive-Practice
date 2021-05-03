class NumMatrix {
    // REFER: https://youtu.be/qAcJnBtVqFw
    private int mat[][];
    public NumMatrix(int[][] matrix) {
        mat = matrix;
    }
    void viewArray1D(int a[])
        {
            System.out.println(Arrays.toString(a));
        }
    void viewArray2D(int arr[][])
        {
            for (int[] row: arr)
            viewArray1D(row);
        }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n+1][m+1];
        for( int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                dp[i][j] = mat[i-1][j-1] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }
        //viewArray2D(dp);
        col1++;col2++;row1++;row2++;
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1]; 

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */