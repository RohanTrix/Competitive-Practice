class Solution {
    public void viewArray2D(char data[][])
    {
        for( char[] a : data)
            System.out.println(Arrays.toString(a));
    }
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        for( int i = n-1; i>=0;i--)
        {
            int last = m;
            for( int j = m-1;j>=0;j--)
            {
                if(box[i][j] == '.')
                    continue;
                if(box[i][j] == '*')
                {
                    last = j;
                    continue;
                }
                else
                {
                    box[i][j] = '.';
                    box[i][last-1] = '#';
                    
                    last--;
                }
            }
            //viewArray2D(box);
            
        }
        char mat[][] = new char[m][n];
        for( int i=0;i<n;i++)
        {
            for( int j = 0;j<m;j++)
            {
                mat[j][n-1-i] = box[i][j];
            }
        }
        return mat;
        
        
    }
}