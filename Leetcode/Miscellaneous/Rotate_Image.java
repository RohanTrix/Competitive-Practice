public class Rotate_Image {
    // IDEA : https://youtu.be/uB0RgD4p3LY
    public void rotate(int[][] mat) {
        int n = mat.length;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<i; j++)
            {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n/2; j++)
            {
                int tmp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = tmp;
            }
    }
}
