public class Solving_Questions_With_Brainpower
{
    // Simple 0/1 knapsack type DP.
    // Your either dont take curr and move to next element or you take curr and jump to next allowed
    long dp[];
    public long maxScore(int i, int ques[][])
    {
        if(i >= ques.length) return 0;
        if(dp[i]!=-1) return dp[i];
        
        return dp[i] = Math.max(maxScore(i+1, ques), maxScore(i+ques[i][1]+1, ques) + ques[i][0]);
    }
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return maxScore(0, questions);
    }
}