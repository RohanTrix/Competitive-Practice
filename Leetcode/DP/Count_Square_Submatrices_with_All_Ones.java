/**
 *      IDEA : If (i,j) be the bottom right corner of the square and if the biggest square that we can form here has a side length
 *             of x, then this means it contains all squares ending at this index with side length<=x. Finding the maximum side length
 *             is a LC problem(Maximal Square). Thus, our final answer be sum of these max side length for each cell.
 */
public class Count_Square_Submatrices_with_All_Ones {
    public int countSquares(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int dp[][] = new int[m][n];
        int cnt = 0;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = mat[i][j];
                else
                {
                    if(mat[i][j]!=0)
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
                cnt+=dp[i][j];
            }
        }
        return cnt;
    }
}
