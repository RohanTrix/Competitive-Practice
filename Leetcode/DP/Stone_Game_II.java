/* IDEA:
        We want to store the maximum score Aice can get. So our DP will be storing everything wrt to
        Alice's score. 

        Our DP[ind][m][p] => 1) if p==0(Alice) then dp[ind][m] = Max Score Alice gets by selecting
                                from curr to curr+2m items.

                                else p==1  then dp[ind][m] = Min score Bob will leave Alice with 

        Follow the comments in the solution to understand after this
*/
public class Stone_Game_II {
    int dp[][][];
    public int maxSum(int ind, int m, int p, int piles[])
    {
        if(ind>=piles.length)return 0; // If there are no piles left, alice will get 0 amount
        if(ind==piles.length-1)return (p==0)?piles[ind]:0; // If we are at last pile and if p =
                                                           //  1) Bob, then we will return empty pile for Alice
                                                           //  2) Alice will take the pile for her score
        
        
        if(dp[ind][m][p]!=-1)return dp[ind][m][p];  // If state is already calculated, return it

        // Alice is playing
        if(p==0)
        {
            int pref = 0; // Store the sum of piles from [ind...curr]
            int maxi = Integer.MIN_VALUE/2;
            for(int i = ind; i<piles.length && i<(ind+2*m); i++)
            {
                pref+=piles[i]; // Add the curr index's pile to running sum
                
                
                // Calculate the new value of m by given formula using the no. of piles currently taken
                int new_m = Math.max(m,i-ind+1); 

                // Store the max(maxi, curr sum of piles taken + amount returned by bob in the next DP state)
                maxi = Math.max(maxi, pref + maxSum(i+1,new_m,1, piles));
            }
            return dp[ind][m][p] = maxi; // Memoize and return
        }
        else
        {
            // For Bob, we need to return the worst value Alice can have(we don't store what Bob wins)
            int mini = Integer.MAX_VALUE/2;
            for(int i = ind; i<piles.length && i<(ind+2*m); i++)
            {
                int new_m = Math.max(m,i-ind+1);
                
                // Store the minimum amount Bob will allow Alice to have
                mini = Math.min(mini,maxSum(i+1,new_m,0, piles));

            }
            return dp[ind][m][p] = mini; // Memoize and return
        } 
    }
    public int stoneGameII(int[] piles)
    {
        int len = piles.length;
        dp = new int[len][len*2][2];
        
        for(int a[][]:dp)
            for(int b[]:a)
                Arrays.fill(b,-1);
        return maxSum(0,1,0, piles);
    }
}
