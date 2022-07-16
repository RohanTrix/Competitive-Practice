/**
 *      IDEA : The question tells us that we can make a horizontal cut or a vertical cut.
 *             So in our DP...those operations will be our transitions. Moreover, one
 *             importantant observation is that...we do not need to store the (r1,c1) and (r2,c2)
 *             to represent a matrix....this is bcuz we only care about the size of the matrix(dimensions).
 *             If there is a price for 2x2 matrices...then it can be used for all 2x2 portions we cut.
 *             Basically, dimension matters for the 
 * 
 *             So DP State : dp[r][c] = Max profit that can be got from a matrix of dimension(rxc).
 *             
 *             DP TRANSITION: Either get profit by selling current (r,c) or partion rowwise or columwise
 *                            and add up the profits of the 2 parts created.
 * 
 * 
 */
public class Selling_Pieces_of_Wood
{
    Long dp[][];
    Map<pair, Long> map = new HashMap<>();
    public long maxProf(int r, int c)
    {
        if(dp[r][c]!=null) return dp[r][c];
        long ans = 0;
        if(map.containsKey(new pair(r,c))) ans = map.get(new pair(r,c));
        for(int p = 1; p<r; p++)
        {
            long firstPart = maxProf(p,c);
            long secondPart = maxProf(r-p, c);
            ans = Math.max(ans, firstPart+secondPart);
        }
        for(int p = 1; p<c; p++)
        {
            long firstPart = maxProf(r,p);
            long secondPart = maxProf(r, c-p);
            ans = Math.max(ans, firstPart+secondPart);
        }
        return dp[r][c] = ans;
    }
    public long sellingWood(int m, int n, int[][] prices) {
        for(int p[] : prices)
            map.put(new pair(p[0], p[1]), (long)p[2]);
        dp = new Long[m+1][n+1];
        return maxProf(m,n);
    }
    private class pair
    {
        int r,c;
        public pair(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
        public boolean equals(Object o)
        {
            pair p = (pair) o;
            return r == p.r && c == p.c;
        }
        public int hashCode()
        {
            return Objects.hash(r,c);
        }
    }
}