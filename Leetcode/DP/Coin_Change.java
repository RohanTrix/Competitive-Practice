package Leetcode.DP;
import java.util.*;
class Coin_Change {
    // (Max_Value - 1 ) is used instead of Max_Value to avoid overflow
    public int coinChange(int[] coins, int amount) {
        
        
        int minCoin[] = new int[amount+1];
        Arrays.fill(minCoin, Integer.MAX_VALUE-1);
        minCoin[0] = 0;
        
        for(int currCoin : coins)
        {
            for(int currAmt = 1; currAmt<=amount; currAmt++)
            {
                if(currCoin <= currAmt)
                {
                    minCoin[currAmt] = Math.min(minCoin[currAmt],minCoin[currAmt - currCoin] +1);
                }
            }
        }
        System.out.println(Arrays.toString(minCoin));
        return (Integer.MAX_VALUE-1==minCoin[amount])? -1 : minCoin[amount];
        
        }
}