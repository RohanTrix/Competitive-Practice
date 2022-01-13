/* IDEA:
        We can see some base cases when 0,1 or 2 coins are left. And the subproblem here is
        that if its Alice's turn, then she should only lose if in the next turn Bob wins 
        in every move possible for him. So we using our standard DP technique:

            * DP STATE :   dp[n][p] =  1 if Player p wins by playing optimally, 
                                       0 if it is not possible for player p to win in any way

            DP TRANSITION:
                           dp[n][p] = 1 if ANY of dp[n-sq][p'] is 0
                                      0 otherwise 
*/
public class Stone_Game_IV {
    int dp[][];
    public int won(int n, int p)
    {
        // Base cases derived by observation
        if(n==1) return 1;
        if(n==2 || n==0) return 0;
        
        // Send DP value if already calculated
        if(dp[n][p]!=-1) return dp[n][p];
        
        // This is the highest value lesser than or equal to the sqrt(n)
        // Simply, sq's square is the maximum we can remove from b
        int sq = (int) Math.floor(Math.sqrt(n));
        
        // We go from sq to 1, and trying to subtract square of each and see the best possible result
        for(int num = sq; num>=1; num--)
        {
            int res = won(n-(num*num), p^1);
            // If player p's opponent is losing in any situation, he will chose that to win this
            if(res==0) return dp[n][p] = 1;
        }
        // He will have to lose if opponent wins in all possible cases
        return dp[n][p] =0;

    }
    public boolean winnerSquareGame(int n) {
        dp = new int[n+1][2];
        for(int a[]: dp) Arrays.fill(a, -1);
        return won(n, 0)==1?true:false;
    }
}
