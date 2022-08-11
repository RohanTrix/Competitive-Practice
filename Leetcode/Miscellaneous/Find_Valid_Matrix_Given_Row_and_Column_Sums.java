public class Find_Valid_Matrix_Given_Row_and_Column_Sums
{
    // REFER : Discuss Section for proof. I had the idea in the beginning but couldn't move forward due to no proof
    //         to check correctness
    // The approach is to place the minimum of rowsum[i] and colsum[j] at cell (i,j)...and then update the rosum and colsum
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int ans[][] = new int[m][n];
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i]-=ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }
        return ans;
    }
}