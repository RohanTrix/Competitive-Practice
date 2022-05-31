public class Set_Matrix_Zeroes // Optimised O(1) Space solution
{
    public void setZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean row = false, col = false;
        // Saving state for row0 : Whether 0 exists in first row or not
        for(int i = 0; i<n; i++)
            if(mat[0][i] == 0) row = true;
        // Saving state for col0 : Whether 0 exists in first col or not
        for(int i = 0; i<m; i++)
            if(mat[i][0] == 0) col = true;
        
        // Traversing all cells except the first row and first col.
        // Marking cell in corresponding row and col as 0 to denote all zeros in that axis
        for(int i = 1; i<m; i++)
            for(int j = 1; j<n; j++)
                if(mat[i][j] == 0)
                {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
        // Going over all cells (except first row and first col) and setting all cells to 0 which
        // have corresponding col val or row val as 0. Rest elements are left untouched.
        for(int i = 1; i<m; i++)
            for(int j = 1; j<n; j++)
                if(mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;
        // Based on first row's state stored previously, making all cells in first row to 0
        if(row)
            for(int i = 0; i<n; i++)
                mat[0][i] = 0;
        // Based on first col's state stored previously, making all cells in first col to 0
        if(col)
            for(int i = 0; i<m; i++)
                mat[i][0] = 0;
        
    }
}