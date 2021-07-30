package Leetcode.DP;

public class Best_Time_to_Buy_and_Sell_Stock_2 {
    public int maxProfit(int[] prices) {
        int minima = prices[0];
        int profit = 0;
        int finalProf = 0;
        int n = prices.length;
        for( int i=1; i< n; i++)
        {
            
            if( prices[i] < prices[i-1])
            {
                finalProf+=profit;
                minima = prices[i];
                profit = 0;
            }
            profit = Math.max(prices[i] - minima, profit);
            
        }
        return profit+finalProf;
        
    }
}