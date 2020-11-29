import java.util.*;
public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), amt = sc.nextInt();
        int coins[] = new int[n];
        //int ways[] = new ways[amt+1];
        
        for(int i=0;i<n;i++) coins[i] = sc.nextInt();
        int ans = coinChange(coins, amt);
        System.out.println(ans);
    }
    // (Max_Value - 1 ) is used instead of Max_Value to avoid overflow
    public static int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
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
            //System.out.println(Arrays.toString(minCoin));
        }
        //
        return (Integer.MAX_VALUE-1==minCoin[amount])? -1 : minCoin[amount];
        
        }
}