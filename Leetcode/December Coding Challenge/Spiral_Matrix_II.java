public class Spiral_Matrix_II {
    // Short Code using Direction Vectors
    // IDEA : Let i, j be coordinates on our grid and di, dj is current direction we need to move. 
    //        In geometrical sense, rotate by 90 degrees clockwise is written as di, dj = -dj, di.
    public int[][] generateMatrix(int n) {
        int i = 0, j = 0, di = 0, dj = 1;
        int val = 1;
        int mat[][] = new int[n][n];
        while(val<=n*n) {
            mat[i][j] = val++;
            int ni = i+di, nj = j+dj;
            // If next cell is out of bounds OR next cell already filled ---> Change the direction
            if(Math.min(ni,nj)<0 || Math.max(ni, nj)>=n || mat[ni][nj]!=0) {
                // di, dj = -dj, di
                int t = dj;
                dj = -di;
                di = t;
            }
            i+=di;
            j+=dj;
        }
        return mat;
    }
    // Solution 2
    public int[][] generateMatrix1(int n) {
        
        int arr[][] = new int[n][n];
        int k=1;
        int row_beg = 0, row_end = n-1, col_beg = 0, col_end = n-1;
        while(k<=n*n)
        {
            //System.out.println("GOING FROM "+col_beg+" TO "+col_end);
        for(int i=col_beg;i<=col_end;i++)
        {
            
            arr[row_beg][i] = k;
            k++;
        }
        row_beg++;
         //System.out.println("GOING FROM "+row_beg+" TO "+row_end);
        
        for(int i = row_beg;i<=row_end;i++)
        {
            arr[i][col_end] =k++;
        }
            col_end--;
        //System.out.println("GOING FROM "+col_end+" TO "+col_beg);

        
        for(int i=col_end;i>=col_beg;i--)
        {
            arr[row_end][i] = k++;
        }
        row_end--;
        //System.out.println("GOING FROM "+row_end+" TO "+row_beg);

        
        for(int i=row_end;i>=row_beg;i--)
        {
            arr[i][col_beg] = k++;
        }
        col_beg++;
        //System.out.println("ITERATION");
        }
        return arr;
    }
}