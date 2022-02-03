// Knapsack Type DP
public class Reducing_Dishes {
    Integer dp[][][];
    public int getMax(int i, int nth, int take, int sat[])
    {
        if(i<0 || (i==0&& nth>1)) return Integer.MIN_VALUE/2;
        if(nth==1&&take==1) return sat[i];
        if(dp[i][nth][take]!=null) return dp[i][nth][take];
        int val = Integer.MIN_VALUE/2;
        
        if(take==0)
            dp[i][nth][0] = Math.max(getMax(i-1,nth,0, sat),getMax(i-1,nth,1, sat));
        else
            dp[i][nth][1] = Math.max(getMax(i-1,nth-1,0, sat), getMax(i-1,nth-1,1,sat));
        return dp[i][nth][take] +=  ((take==1)?nth*sat[i]:0);
    }
        
    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        dp = new Integer[sat.length][sat.length+1][2];
        int ans = 0;
        for(int i = 1; i<=sat.length; i++)
            ans = Math.max(ans, Math.max(getMax(sat.length-1,i,0, sat),getMax(sat.length-1,i,1, sat)));
        return ans;
    }
}
