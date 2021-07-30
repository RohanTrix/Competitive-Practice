package Leetcode.DP;

import java.util.Arrays;

class Best_Time_to_Buy_and_Sell_Stock_4 {
    // Refer Tushar Roy Video for explanation
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int profit[][] = new int[k+1][n];
        int profit1=0, profit2=0;
        if( n==0 || n==1) return 0;
        Arrays.fill(profit[0], 0);
        for(int i=0;i<k+1;i++)
            profit[i][0] = 0;
        
        for(int i=1;i<k+1;i++)
        {
            for(int j=1;j<n;j++)
            {
                // Profit by not transacting on jth day and keeping the number                  of transactions uptil jth day same
                profit1 = profit[i][j-1];
                
                // Best you can get by completing transaction on jth day
                profit2 = 0;
                // 
                for(int m = 0; m<=j-1; m++)
                {
                    profit2 = Math.max(profit2,                                                          (prices[j] - prices[m]) + profit[i-1][m]);
                }
                //profit[i-1][m] = Profit of previous transaction when not                        buying on mth day
                // (prices[j] - prices[m]) = Profit by Buying on mth day and                        selling on latest jth day     
                
                profit[i][j] = Math.max(profit1, profit2);
            }
        }
        return profit[k][n-1];
        
    }
}