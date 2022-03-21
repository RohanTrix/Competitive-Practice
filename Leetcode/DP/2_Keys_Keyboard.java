// DP STATE : dp[i][cnt] = Min steps to make A appear n times with i times written on screen
//            already and with cnt no. of copies in clipboard

public class 2_Keys_Keyboard {
    int N;
    Integer dp[][];
    public int minCost(int i, int cnt)
    {
        if(i>N) return Integer.MAX_VALUE/2;
        if(i == N) return 0;
        if(dp[i][cnt]!=null) return dp[i][cnt];
        
        int m1 = cnt !=0?(1 + minCost(i+cnt, cnt)):Integer.MAX_VALUE/2;;
        int m2 = i == cnt?Integer.MAX_VALUE/2:minCost(i, i) + 1;
        
        return dp[i][cnt] = Math.min(m1, m2);
        // paste : minCost(i+cnt, cnt)
        // copy  : minCost(i, i)
        
    }
    public int minSteps(int n) {
        dp = new Integer[n+1][n+1];
        N = n;
        return minCost(1, 0);
    }
}
