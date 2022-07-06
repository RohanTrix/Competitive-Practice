package Leetcode.Miscellaneous;

// Direction Vector based code
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        for (int i = 0; i < m * n; i++) {
            ans.add(mat[x][y]);
            mat[x][y] = 101;
            int nx = x + dx, ny = y + dy;
            if (Math.min(nx, ny) < 0 || nx >= m || ny >= n || mat[nx][ny] == 101) {
                // dx = dy and dy = -dx
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
            x = x + dx;
            y = y + dy;
        }
        return ans;
    }
}

// Human Readable Code
public class Spiral_Matrix1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Going Right
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            if (rowStart > rowEnd)
                break;

            // Going down
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colStart > colEnd)
                break;
            // Going left
            for (int i = colEnd; i >= colStart; i--) {
                list.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowStart > rowEnd)
                break;
            // Going Up
            for (int i = rowEnd; i >= rowStart; i--) {
                list.add(matrix[i][colStart]);
            }
            colStart++;
            if (colStart > colEnd)
                break;

        }
        return list;
    }
}
