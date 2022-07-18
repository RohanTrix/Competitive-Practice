/*
 *      IDEA : Since we want to keep all zeros above the diagnol, we basically want to keep rows
 *             with trailing zeros satifying the requirement for each row.
 *              
 *             Simply, the requirement for each row is the minimum no. of trailing zeros it should have
 *             For example, row 0 should have at least n-1 trailing zeros, row 1 should have at least
 *             n-2 trailing zeros etc.
 * 
 *             Now, we basically want to find out the minimum no. of swaps to satify each row. 
 *             While traversing, we can be greedy in the selection of which row 
 *             should be swapped to our current row. This can be acheived by taking the first row
 *             below it(because the above ones have already been fulfilled with their requirement) which
 *             has >=req no. of zeros. THE FACT THAT THE REQUIREMENT DECREASES BY ONE DOWN THE ROWS, we
 *             would not really need current req no. of trailing zeros again to fulfill rows with req
 *             lower than us.
 * 
 */
public class Minimum_Swaps_to_Arrange_a_Binary_Grid
{
    public int minSwaps(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int trail[] = new int[m];
        for(int i = 0; i<m; i++)
        {
            for(int j = n-1; j>=0;j--)
            {
                if(grid[i][j] == 0)
                    trail[i]++;
                else break;
            }
        }
        int cnt = 0;
        int req = m-1;
        for(int i = 0; i<m; i++)
        {
            int j = i;
            while(j<n && trail[j]<req) j++;
            if(j == n) return -1;
            while(j>i)
            {
                int tmp = trail[j];
                trail[j] = trail[j-1];
                trail[j-1] = tmp;
                cnt++;
                j--;
            }
            req--;
        }
        return cnt;
    }
}