package Leetcode.Miscellaneous;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, rowEnd = matrix.length-1, colStart = 0, colEnd = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            // Going Right
            for(int i = colStart; i<=colEnd; i++)
            {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            if(rowStart>rowEnd) break;
            
            // Going down
            for(int i = rowStart; i<=rowEnd; i++)
            {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(colStart>colEnd) break;
            // Going left
            for(int i = colEnd; i>=colStart; i--)
            {
                list.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(rowStart>rowEnd) break;
            // Going Up
            for(int i = rowEnd;i>=rowStart; i--)
            {
                list.add(matrix[i][colStart]);
            }
            colStart++;
            if(colStart>colEnd) break;

        }
        return list;
    }
}
