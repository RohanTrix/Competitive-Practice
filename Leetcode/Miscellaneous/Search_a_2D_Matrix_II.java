/**
 *      IDEA : We start from the top right cell since it is the highest element in the first row
 *             and the smallest in the last column. Either we can use this cell to start or the bottom left one.
 *             The reason is...in these cells...we will have an option to eliminate the current row or current col,
 *             based on the value of the current cell.
 * 
 *             The idea is 
 *             1) If the current value > target  --> then since all the values in the current column are larger
 *             than current val...hence definetly all of them will be larger than target. Do col--
 *             
 *             2) If the current value < target  --> then since all the values in the current row are lesser than current
 *             val...so definetly all of them will be lesser than target. Do row++
 * 
 *             3) If same value, return true
 * 
 */

public class Search_a_2D_Matrix_II
{
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        int r = 0, c = n-1;
        while(r<m && c>=0)
        {
            if(target > mat[r][c])
                r++;
            else if(target<mat[r][c])
                c--;
            else
                return true;
        }
        return false;
    }
}