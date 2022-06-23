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
// Recursive DP
class Solution {
    Integer dp[][];
    int prices[];
    public int maxProf(int i, int hold)
    {
        if(i == prices.length)
            return 0;
        if(dp[i][hold]!=null) return dp[i][hold];
        
        int ch1 = 0,ch2 = 0;
        // Not holding a stock
        if(hold == 0)
        {
            ch1 = maxProf(i+1, 1) - prices[i]; // Buy current stock by giving prices[i]
            ch2 = maxProf(i+1, 0);             // Do not do anything
        }
        // Holding  a stock
        else
        {
            ch1 = maxProf(i+1, 0) + prices[i]; // Sell curr stock by getting prices[i] as profit
            ch2 = maxProf(i+1, 1);
        }
        return dp[i][hold] = Math.max(ch1, ch2);
    }
    
    public int maxProfit(int[] prices) {
        this.prices = prices;
        int n = prices.length;
        dp = new Integer[n][2];
        return maxProf(0,0);
    }
}