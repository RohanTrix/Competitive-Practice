package Leetcode.DP;

import java.util.*;
class Best_Time_to_Buy_and_Sell_Stock_3 {
    public int maxProfit(int[] prices) {
        // REFER Tech Dose Video for explanation
        // Divide and Conquer approach used
        // Maintaining 2 arrays 'left' and 'right' which stores profits if doing 1 transaction from left and right respectively

        int n = prices.length, i;
        if(n==0 || n==1) return 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        // FILLING UP LEFT ARRAY
        int minPrice = prices[0];    
        for(i=1;i<n; i++)
        {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            left[i] = Math.max(left[i-1], prices[i] - minPrice);
        }
        // FILLING UP RIGHT ARRAY
        int maxPrice = prices[n-1];
        for(i=n-2;i>=0; i--)
        {
            if(maxPrice < prices[i])
                maxPrice = prices[i];
            right[i] = Math.max(right[i+1],maxPrice - prices[i] );
        }
        int profit = right[0];
        viewArray1D(left);
        viewArray1D(right);

        // DIVIDE THE ARRAY AS left[i-1] + right[i] to find the best profit on both sides when divided on ith day
        for(i =1; i<n;i++)
            profit = Math.max(profit, left[i-1] + right[i]);
        return profit;
    }
    static void viewArray1D(int a[])
        {
            System.out.println(Arrays.toString(a));
        }
}