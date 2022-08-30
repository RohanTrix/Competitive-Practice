public class Sort_the_Matrix_Diagonally
{
    int m,n;
    public void sort(int mat[][], int i, int j)
    {
        int x = i;
        int cnt[] = new int[101];
        int y = j;
        while(x<m && y<n)
            cnt[mat[x++][y++]]++;
        
        x = i; y = j;
        for(int num = 1; num <=100; num++)
            for(int c = 0; c<cnt[num]; c++)
                mat[x++][y++] = num;
    }
    public int[][] diagonalSort(int[][] mat) {
        m = mat.length; n = mat[0].length;
        
        for(int i = 0; i<m; i++)
            sort(mat, i, 0);
        for(int j = 1; j<n; j++)
            sort(mat, 0,j);
        
        return mat;
    }
}