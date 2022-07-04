public class Spiral_Matrix_IV
{
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int mat[][] = new int[m][n];
        int rowStart = 0, rowEnd = m-1, colStart = 0, colEnd = n-1;
        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            // Going Right
            for(int i = colStart; i<=colEnd; i++)
            {
                mat[rowStart][i] = head == null?-1:head.val;
                head = head == null?null:head.next;
            }
            rowStart++;
            if(rowStart>rowEnd) break;
            // Going bottom
            for(int i = rowStart; i<=rowEnd; i++)
            {
                
                mat[i][colEnd] = head == null?-1:head.val;
                head = head == null?null:head.next;
            }
            colEnd--;
            if(colStart>colEnd) break;
            // going left
            for(int i = colEnd; i>=colStart; i--)
            {
                mat[rowEnd][i] = head == null?-1:head.val;
                head = head == null?null:head.next;
            }
            rowEnd--;
            if(rowStart>rowEnd) break;
            // going upwards
            for(int i = rowEnd;i>=rowStart; i--)
            {
                mat[i][colStart] = head == null?-1:head.val;
                head = head == null?null:head.next;
            }
            colStart++;
            if(colStart>colEnd) break;
        }
        return mat;
    }
}