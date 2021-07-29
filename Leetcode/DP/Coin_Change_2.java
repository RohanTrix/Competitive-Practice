package Leetcode.DP;
import java.util.*;
public class Coin_Change_2 {
    public int change(int amount, int[] coins) {
        
        
        int ways[] = new int[amount+1];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        
        for(int currCoin : coins)
        {
            for(int currAmt=1; currAmt<=amount ;currAmt++)
                {
                    if( currCoin <= currAmt)
                    {
                        ways[currAmt] += ways[currAmt- currCoin];
                    }              
                }        
        }
        //System.out.println(Arrays.toString(ways));
        return ways[amount];
    }
}