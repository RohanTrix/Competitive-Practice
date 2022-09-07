/**
 *      IDEA : The first hint towards bitmasking here should be the constraints since it was unusually
 *             low for a matrix-type problem
 *             
 *             We can first represent each row as a bitmask of columns. Now, the idea is
 *             to try every mask with `numSelect` no. of columns and check how many rows it covers.
 *             And finally we will return the maximum no. of rows covered by any mask.
 * 
 *             A cute trick to check if columns of the mask are a subset of the active cols of some ith row,
 *             is to just take the AND of the two and check if it is equal to the mask of active cols.
 *             Basically if p & S == p, then p is a SUBSET of S
 *             
 */

public class Maximum_Rows_Covered_by_Columns {
    public int maximumRows(int[][] mat, int numSelect) {
        int m = mat.length, n = mat[0].length;
        int arr[] = new int[m];
        
        // Converting 2D matrix to array of column masks
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(mat[i][j] == 1)
                    arr[i]|=(1<<j);
        int maxi = 0;
        for(int mask = 1; mask<=1<<n; mask++) // Trying all masks
        {
            if(Integer.bitCount(mask) != numSelect) continue; // We only care about the masks with bitCount == numSelect
            
            int cnt = 0;
            for(int i = 0; i<m; i++)
                if((mask&arr[i]) == arr[i]) // Checking if arr[i] is a SUBSET of `mask`
                    cnt++; // If yes, then this row is covered
            maxi = Math.max(maxi, cnt); // Maximising rows
        }
        return maxi;
    }
}
