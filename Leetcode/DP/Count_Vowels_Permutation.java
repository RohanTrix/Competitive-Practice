package Leetcode.DP;
// Easy....for ith char, check dp[i-1][ch] where ch are all chars from which ith can follow
public class Count_Vowels_Permutation {
    public int countVowelPermutation(int n) {
        long dp[][] = new long[n][5];
        // a-0, e-1, i-2, o-3, u-4
        int mod = 1000_000_007;
        for(int i = 0;i<5; i++)dp[0][i] = 1;
        for(int i  =1; i<n;i++)
        {
            // For a
            dp[i][0]+=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;
            
            //For e
            dp[i][1]+=(dp[i-1][0]+dp[i-1][2])%mod;
            
            //For i
            dp[i][2]+=(dp[i-1][1]+dp[i-1][3])%mod;
            
            //For o
            dp[i][3]+=(dp[i-1][2])%mod;
            
            //For u
            dp[i][4]+=(dp[i-1][2]+dp[i-1][3])%mod;
        }
        long sum = 0;
        for(int i = 0;i<5; i++)
            sum=(sum+dp[n-1][i])%mod;
        return (int)sum;
    }
}
