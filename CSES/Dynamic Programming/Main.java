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
        
        
        
        }
}