/* IDEA:
        Our DP definition is:
        dp[i][j][p] = 
            if p=0(Alice), then we store max Sum Alice can receive
            if p=1(Bob),   then we subtract the value Bob receives from
                           worst(min) value he will leave for Alice.
        
        So finally we will receive the difference of the score as our answer.
        Follow comments for further explanation
*/


public class Stone_Game_VII {
    // Stores prefix sum of stones
    int pref[];
    int dp[][][];

    // Precompute Prefix Sum
    public void precomp(int stones[])
    {
        pref = new int[stones.length+1];
        for(int i = 0; i<stones.length;i++) pref[i+1] = pref[i] + stones[i];
    }
    

    public int maxScore(int i, int j, int p)
    {
        // After last element picked, no score is acheived
        if(i==j)return 0;
        
        // Send memoized result if available
        if(dp[i][j][p]!=-1)return dp[i][j][p];

        // Alice is playing
        if(p==0)
        {
            // Choice 1
            // Pick first element..so add sum of remaining array(using prefix sum) to score
            // and send the remaining array to Bob
            int ch1 = (pref[j+1]-pref[i+1+1-1]) + maxScore(i+1,j,1);
            
            // Choice 2
            // Pick second element..so add sum of remaining array(using prefix sum) to score
            // and send the remaining array to Bob
            int ch2 = (pref[j-1+1]-pref[i+1-1]) + maxScore(i,j-1,1);

            // Return the highest score Alice can have
            return dp[i][j][p] = Math.max(ch1,ch2);
        }
        // Bob is playing
        else
        {
            // Choice 1
            // Pick first element..so subtract the sum of remaining array(using prefix sum) from score
            // and send the remaining array to Alice
            int ch1 = maxScore(i+1,j,0)-(pref[j+1]-pref[i+1+1-1]);

            // Choice 2
            // Pick second element..so subtract the sum of remaining array(using prefix sum) from score
            // and send the remaining array to Alice
            int ch2 = maxScore(i,j-1,0) - (pref[j-1+1]-pref[i+1-1]);

            // Bob will try to minimize the difference, so he will send the smaller sc
            return dp[i][j][p] = Math.min(ch1,ch2);
        }
    }
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        precomp(stones);
        dp = new int[len][len][2];
        for(int a[][]:dp)for(int b[]:a)Arrays.fill(b,-1);
        return maxScore(0,len-1,0);
    }
}
