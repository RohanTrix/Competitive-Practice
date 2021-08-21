package Leetcode.DP;

public class Longest_Palindromic_Substring {
    // CODE is very similar to LC : Count Palindromes -> Check that and learn
    public String longestPalindrome(String st) {
        int n = st.length();
        if(n==1)return st;
        int s=0,e = 0;
        char str[] = st.toCharArray();
        boolean dp[][] = new boolean[st.length()][st.length()];
        for(int i =0; i<n; i++)
        {
            dp[i][i] = true;
            if(i<n-1)
            {
                dp[i][i+1] = false;
                if(str[i]==str[i+1])
                {
                    dp[i][i+1] = true;
                    s = i;
                    e = i+1; 
                }
            }
        }
        //view(dp);
        
        for(int p =2; p<n; p++)
        {
            for(int i =0, j=p; j<n; i++,j++)
            {
                dp[i][j] = false;
                if(str[i]==str[j] && dp[i+1][j-1])
                {
                    dp[i][j] = true;
                }
                if(dp[i][j])
                {
                    s = i;
                    e = j;
                }
            }
        }
        String snew = "";
        for(int i = s; i<=e; i++)
            snew+=str[i];
        return snew;
    }
}
