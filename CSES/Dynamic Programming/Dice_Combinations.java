import java.util.*;
public class Dice_Combinations {
    public static void main(String args[])
    {
        int mod = 1000000007;
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        long ways[] = new long[n+1];
        ways[0] =1;
        for(int i=1; i<=n;i++){
        for(int j=1; j<7; j++)
        {
             if(j<=i)
                ways[i] += ways[i-j] % mod;
            }
        }
        System.out.println(ways[n]);
    }
}
