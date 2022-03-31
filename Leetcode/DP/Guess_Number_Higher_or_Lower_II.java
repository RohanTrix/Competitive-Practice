/*
    IDEA : We want to minimise our worst(max) cost. Moreover, since the explanation itself shows
            a recurisve structure, we can think of DP here.

            The question wants the min cost of the worst case when the game is played from 1 to n. So this
            is a DnC type DP. This is clear by reading the example.

            DP STATE : dp[i][j] = Min cost of reaching the worst case when we have choices from i to j.

            DP TRANS: At every choice(ch) between i<j, we try to make a choice. We call the remaining left
            and right partitions because we consider this choice to not be the right answer. Now, we want to 
            take the max(left path, right path) since we want the worst case. And to this max we add the cost of
            selecting the current no. Finally, we take min of all such worst paths.

*/
public class Guess_Number_Higher_or_Lower_II {
    Integer dp[][];
    public int getMaxCost(int i, int j)
    {
        // System.out.println(i+" "+j);
        if(i >= j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int ch = i; ch<=j; ch++)
        {
            ans = Math.min(ans, ch + Math.max(getMaxCost(i, ch-1), getMaxCost(ch+1, j)));
        }
        return dp[i][j] = ans;
    }
    public int getMoneyAmount(int n) {
        dp = new Integer[n+1][n+1];
        return getMaxCost(1, n);
    }
}
