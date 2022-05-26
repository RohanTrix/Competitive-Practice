public class Rotate_Image {
    // IDEA : https://youtu.be/uB0RgD4p3LY
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose matrix
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // Reverse each row
        for(int row[] : matrix)
        {
            for(int i = 0; i<n/2; i++)
            {
                int tmp = row[i];
                row[i] = row[n-i-1];
                row[n-i-1] = tmp;
            }
        }
    }
}
