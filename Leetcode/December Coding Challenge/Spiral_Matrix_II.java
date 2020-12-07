public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        
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