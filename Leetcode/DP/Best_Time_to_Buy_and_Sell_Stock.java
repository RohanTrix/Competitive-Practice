package Leetcode.DP;
// Idea : Keep finding the min uptil ith index...subtract it from prices[i]...update profit is better than previous
class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int maxProf = 0;
        int n = prices.length;
        for(int i=0;i<n; i++)
        {
            lowest = Math.min(prices[i], lowest);
            maxProf = Math.max(prices[i] - lowest, maxProf);
        }
        return maxProf;
    }
}