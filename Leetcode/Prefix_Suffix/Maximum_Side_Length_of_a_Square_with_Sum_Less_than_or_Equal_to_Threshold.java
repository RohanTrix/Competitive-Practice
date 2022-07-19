/**
 *      IDEA : We maintain row wise prefix sum.....do a sliding window on the columms...for some c1..c2,
 *             If all square matrices within this range have a sum>threshold...then we decrease our window
 */
public class Maximum_Side_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold {
    
    public boolean process(int c1, int c2, int len, int pref[][], int threshold)
    {
        boolean ans = true; // We have not found matrix with sum<=thresh
        int sum =0;
        for(int r = 0; r<pref.length; r++)
        {
            sum+=pref[r][c2] - pref[r][c1-1];
            if(r>=len)
                sum-=pref[r-len][c2] - pref[r-len][c1-1];
            if(r>=len-1)
                ans = ans && sum>threshold;
        }
        return ans;
        
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
 
        int pref[][] = new int[m][n+1];
        for(int i = 0; i<m;i++)
        {
            int row[] = pref[i];
            for(int j = 1; j<=n;j++)
            {
                row[j] = row[j-1]+mat[i][j-1];
            }
        }
        int c1 = 1;
        int maxi = 0;
        for(int c2 = 1; c2<=n; c2++)
        {
            int len = c2-c1+1;
            while(process(c1, c2, len, pref, threshold))
            {
                c1++;
                len = c2-c1+1;
            }
            maxi = Math.max(len, maxi);
        }
        return maxi;
    }
}


/**
 *      IDEA : Binary Search on Length of Square matrix...scrape all such squares...
 *             For some chosen side length...if any square has a sum<=threshold...then increase side length
 *             in matrix search.
 * 
 */

public class Maximum_Side_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold1 {
    
    boolean maxMatVal(int pref[][], int len, int maxSum)
    {
        int m = pref.length-1, n = pref[0].length-1;
        for(int i = 1; i<=m; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                int x1 = i, y1 = j;
                int x2 = i+len, y2 = j+len;
                if(x2>m || y2>n) continue;
                int val = pref[x2][y2] - pref[x2][y1-1] - pref[x1-1][y2] + pref[x1-1][y1-1];
                if(val<=maxSum) 
                    return true;
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
 
        int pref[][] = new int[m+1][n+1];
        for(int i = 1; i<=m;i++)
        {
            for(int j = 1; j<=n;j++)
            {
                pref[i][j] = pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int l = 0, r = Math.min(m,n), ans = 0;
        while(l<=r)
        {
            int len = (l+r)/2;
            if(maxMatVal(pref, len, threshold))
            {
                ans = len;
                l =  len + 1;
            }
            else r = len - 1;
        }
        return ans;
    }
}
