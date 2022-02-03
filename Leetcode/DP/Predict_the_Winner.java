/*
    IDEA: SAME LOGIC AS STONE GAME, but in that question there was a O(1) solution because the array was even sized. So even or odd cells
          could be chosen before hand.

          DP STATE: dp[i][j] = Difference of score between 2 players.

          p=0 wants to maximise this score, p=1 wants to minimise

          DP TRANSITION:
            DP[i][j] = Math.max(nums[i]+DP(i+1,j,1^p), nums[j]+DP(i, j-1,1^p));    IF p=0
            DP[i][j] = Math.min(-nums[i]+DP(i+1,j,1^p), -nums[j]+DP(i, j-1,1^p));


*/

public class Predict_the_Winner {
    Integer dp[][];
    int nums[];
    public int maxScore(int i, int j, int p)
    {
        if(i==j) return dp[i][j] = (p==0)?nums[i]:-nums[i];
        if(dp[i][j]!=null) return dp[i][j];
        
        if(p==0)
            return dp[i][j] = Math.max(nums[i]+maxScore(i+1,j,1^p), nums[j]+maxScore(i, j-1,1^p));
        else
            return dp[i][j] = Math.min(-nums[i]+maxScore(i+1,j,1^p), -nums[j]+maxScore(i, j-1,1^p));
    }
    public boolean PredictTheWinner(int[] arr) {
        nums = arr;
        dp = new Integer[nums.length][nums.length];
        int val = maxScore(0, nums.length-1,0 );
        //System.out.println(val);
        return val>=0;
    }
}
