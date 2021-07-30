package Leetcode.DP;

class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    // REFER video link for explanation: https://youtu.be/pTQB9wbIpfU
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2]; // rows are stocks prices, column is bought state or sold                                            state
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i =1; i<n; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            // Bought state at ith day/value
            // Max b/w holding prev bought stock and old profit after selling - money for buying                 ith stock
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0] -fee);
            // Max b/w maintaining prev sold state profit and selling a previously held stock at             // prices[i] with a deduction of fee
        }
        return dp[n-1][1];// Return last sold state
    }
}