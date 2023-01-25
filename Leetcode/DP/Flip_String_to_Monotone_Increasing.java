/**
 *      IDEA :  DP STATE : 
 *     
 *                  DP[i][0/1] =  Min moves to convert seq[0...i] with ith char ending in a 0/1
 *                  
 *              DP TRANS :
 *                  To change a bit at current position we have to do 1 op.
 *                  --> If rest of seq has to end in 0, it can only come from 0( ex. 0000000)
 *                  --> If rest of seq has to end in 1, it can be either of the 2 scenarios(ex. 000001  OR 000001111)
 * 
 */

public class Flip_String_to_Monotone_Increasing
{
    public int minFlipsMonoIncr(String str) {
        char s[] = str.toCharArray();
        int n = s.length;
        
        int dp[][] = new int[n][2];
        dp[0][0] = s[0]=='0'?0:1;
        dp[0][1] = s[0]=='1'?0:1;
        
        for(int i = 1; i<n; i++)
        {
            dp[i][0] = dp[i-1][0] + (s[i]=='0'?0:1);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (s[i]=='1'?0:1);
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}