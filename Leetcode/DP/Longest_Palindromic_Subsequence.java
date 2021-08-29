package Leetcode.DP;


public class Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String str) {
        int n = str.length();
        if(n==1) return 1;
        

        char s[] = str.toCharArray();
        int dp[][] = new int[n][n];

        //Init Substrings of length 1
        for(int i  =0; i<n; i++)
            dp[i][i] = 1;
        
        //Init Substrings of length 2
        for(int i =0; i<n-1; i++)
        {
            dp[i][i+1] = (s[i]==s[i+1])?2:1;
            
        }
        
        // Diagnolly traversing the array
        // Here dp[i][j] represents the longest palindromic subsequence in substring s[i:j]
        for(int p =2; p<n; p++)
        {
            for(int i =0, j=p; j<n; i++,j++) // i, j will represent substring s[i:j] (both inclusive)
            {
                if(s[i]==s[j])
                    dp[i][j] = dp[i+1][j-1] +2;
                    // If chars at i,j are equal we can take these 2 + best subseq from string s[i+1 : j-1]
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    // If chars are not equal, we should take the best of substring s[i+1:j] and s[i:j+1]

            }
        }
        return dp[0][n-1]; // answer for string s[0:n-1] (full string)
        
    }
}