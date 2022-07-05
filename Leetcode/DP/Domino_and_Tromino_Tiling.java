/**
 *      IDEA :
 *              
 *              DP STATE : dp[i][colState] = Stores no. of ways to put tiles on grid 2*i with current colState as
 *                                              0(00) => Both cells of current column are empty
 *                                              1(01) => Top cell empty and Bottom cell covered
 *                                              2(10) => Top cell covered and Bottom cell empty
 * 
 *             DP TRANSITION => Try to draw by placing a domino or trimino adhering to the colState of the current cell
 */
public class Domino_and_Tromino_Tiling {
    Long dp[][];
    int mod = (int)1e9+7;
    public long ways(int i,int colState)
    {
        if(i<0) return 0L;
        if(i == 0)
            return colState == 0?1L:0L;
        if(dp[i][colState]!=null)
            return dp[i][colState];
        long cnt = 0;
        if(colState == 0)
            cnt+=ways(i-1, 0)+ways(i-2, 0)+ways(i-1,1)+ways(i-1,2);
        
            else if(colState == 1)
            cnt+=ways(i-1,2)+ways(i-2, 0);

        else if(colState == 2)
            cnt+=ways(i-1,1)+ways(i-2,0);

        cnt%=mod;
        return dp[i][colState] = cnt;
    }
    public int numTilings(int n) {
        dp = new Long[n+1][4];
        return (int)ways(n, 0);
    }
}
