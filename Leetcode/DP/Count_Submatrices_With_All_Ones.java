/**
 *      o(N3) solution
 *      EXPLAINED IN OneNote in Subarray Problems
 */
public class Count_Submatrices_With_All_Ones {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // Run length Encoding --- Max continuous ones in the row ending at curr cell
        for(int i = 0; i<m; i++)
        {
            int row[] = mat[i];
            for(int j = 1; j<n;j++)
            {
                if(row[j]!=0)
                    row[j]+=row[j-1];
            }
        }
        int ans = 0;
        // Choosing top-right corner
        for(int r1 = 0; r1<m; r1++)
        {
            for(int c1 = 0; c1<n; c1++)
            {
                int minBreadth = mat[r1][c1];
                for(int r2 = r1; r2<m; r2++)
                {
                    minBreadth = Math.min(minBreadth, mat[r2][c1]);
                    ans+=minBreadth;
                }
            }
        }
        return ans;
    }
}
