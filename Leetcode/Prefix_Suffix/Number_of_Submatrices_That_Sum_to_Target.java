/**
 *      PREREQ : Maximum Sum Rectangle and Count of subarray with sum = k
 *      IDEA : The idea is to build a row-wise prefix sum for each row in the matrix
 *             like we did in Maximum Sum Rectangle. Now...we imagine a range of columns in a row
 *             (i,j) as a SINGLE CELL whose value is the sum of cells in this range(using prefix sum)
 *             
 *             So we consider every pair of colums in O(n^2) and now...the problem for one such
 *             iteration is the 1D array problem of counting subarrays with sum = k which can be solved
 *             using Running sum and HashMap approach.
 */

public class Number_of_Submatrices_That_Sum_to_Target {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        int pref[][] = new int[m][n+1];
        for(int i = 0; i<m; i++)
        {
            int nums[] = mat[i];
            int p[] = pref[i];
            for(int j = 1; j<=n;j++)
                p[j] = p[j-1]+nums[j-1];
        }
        int cnt = 0;
        for(int i = 1; i<=n; i++)
        {
            for(int j = i; j<=n; j++)
            {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                int currSum = 0;
                for(int r = 0; r<m; r++)
                {
                    int num = pref[r][j] - pref[r][i-1];
                    currSum+=num;
                    cnt+=map.getOrDefault(currSum-target,0);
                    map.put(currSum, map.getOrDefault(currSum, 0)+1);
                }
            }
        }
        return cnt;
    }
}
