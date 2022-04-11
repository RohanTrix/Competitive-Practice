package Leetcode.DP;

/*
    IDEA : We have 3 types of moves. We can easily form a recursive relation for the problem.

           DP STATE: dp[i][k] = Y/N whether it is possible to reach last cell from ith element with last move as k.

           DP transition is easily noticeable from question.

*/
public class Frog_Jump {
    Boolean dp[][];
    public boolean possible(int i, int k, int stones[])
    {
        if(i == stones.length-1) return true;
        if(dp[i][k]!=null) return dp[i][k];
        
        int move1 = stones[i]+k; // k jump
        int move2 = move1+1;     // k+1 jump
        int move3 = move1-1;     // k-1 jump
        boolean ans = false;  // If any of the moves returns true, then final answer to be able to reach from here is YES
        // We loop forwards to check
        for(int p = i+1; p<stones.length; p++)
        {
            if(stones[p] == move1)
                ans = ans || possible(p, k, stones);
            if(stones[p] == move2)
                ans = ans || possible(p, k+1, stones);
            if(stones[p] == move3)
                ans = ans || possible(p, k-1, stones);
        }
        return dp[i][k] = ans;
    }
    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length];
        boolean ans = possible(1, 1, stones);
        //System.out.println(Arrays.toString(dp));
        return ans && stones[1]-stones[0] == 1;
    }
}
