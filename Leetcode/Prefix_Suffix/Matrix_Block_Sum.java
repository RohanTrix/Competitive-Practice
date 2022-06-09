/* IDEA:
1) Create a 2D prefix array
2)  Find the pref value of a sub matrix between (i-k, j-k) and (i+k, j+k). If any index goes beyond the 
    matrix limits, then initialise  it to the closest limit (0 or n) of the matrix.

*/

public class Matrix_Block_Sum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m  = mat.length;
        int n = mat[0].length;
        int pref[][] = new int[m+1][n+1];
     
        for(int i  = 1; i<=m; ++i)
        {
            for(int j = 1; j<=n; ++j)
            {
                pref[i][j] = pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int ans[][] = new int[m][n];
        for(int i  = 1; i<=m; ++i)
        {
            for(int j = 1; j<=n; ++j)
            {
                int r1 = Math.max(i-k, 1), c1 = Math.max(j-k,1); // Upper left point
                int r2 = Math.min(i+k, m), c2 = Math.min(j+k,n); // Lower Right point
                ans[i-1][j-1] = pref[r2][c2] - pref[r2][c1-1] - pref[r1-1][c2] + pref[r1-1][c1-1];
                
            }
        }
        return ans;
        
    }
}
