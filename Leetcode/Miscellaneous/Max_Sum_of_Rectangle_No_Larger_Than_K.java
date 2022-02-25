public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    // Explained in OneNote : Subarray Problems
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int pref[][] = new int[m][n+1];
        for(int i = 0; i<m; i++)
        {
            int arr[] = pref[i];
            for(int j = 1; j<=n;j++)
            {
                arr[j] = arr[j-1] + matrix[i][j-1];
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++)
        {
            for(int j = i; j<=n; j++)
            {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int currSum = 0;
                for(int row = 0; row<m; row++)
                {
                    int currVal = pref[row][j] - pref[row][i-1];
                    currSum+=currVal;
                    Integer findVal = ts.ceiling(currSum-k);
                    if(findVal !=null)
                        maxi = Math.max(maxi, currSum-findVal);
                    ts.add(currSum);
                }
            }
        }
        return maxi;
    }
}
