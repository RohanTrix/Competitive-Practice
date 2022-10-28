public class Image_Overlap {
    /**
     *      IDEA : The first thing to note is that the size of the matrix is quite less (30)
     *             that mean we can go up to O(n^4).
     *             Next, think about ONE cell....let's say cell (0,0)...upto where can this cell be shifted at max ? 
     *             It can be shifted to the very bottom, or to the very right...or to the most bottom-right point at max.
     *             Similar analysis can be done for cells like  (0,n-1), (n-1,0) or (n-1,n-1)
     * 
     *             Thus, we want to do some amt of left/right shifts and some amt of up/down shifts...and then check
     *             how many '1' cell overlaps we get. So we will brute force the shifts using variables dx and dy
     *             which will translate a cell (x, y) -> (x+dx, y+dy)...Since there is no rotation here and ONLY SHIFTS,
     *             So any cell that falls out of the matrix after translation shoudl be ignored
     * 
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxi = 0;
        for(int dx = - (n-1); dx <= n-1; dx++)
            for(int dy = - (n-1); dy <= n-1; dy++)
            {
                int trans[][] = new int[n][n];
                for(int x = 0; x<n; x++)
                    for(int y = 0; y<n; y++)
                    {
                        int nx = x + dx, ny = y + dy;
                        if(img1[x][y] == 0 || Math.min(nx, ny) < 0 || Math.max(nx, ny)>=n)
                            continue;
                        trans[nx][ny] = 1;
                    }
                // Compare
                int cnt = 0;
                for(int x = 0; x<n; x++)
                    for(int y = 0; y<n; y++)
                        if(img2[x][y] == 1 && trans[x][y] == img2[x][y])
                            cnt++;
                maxi = Math.max(maxi, cnt);
            }
        return maxi;
    }
}
