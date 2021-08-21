package Leetcode.DP;
public class Palindromic_Substrings
{
    // Note: We traverse diagnolly in this problem
    // REFER: https://youtu.be/XmSOWnL6T_I
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==1)return 1;
        int cnt = n;
        char str[] = s.toCharArray();
        boolean dp[][] = new boolean[s.length()][s.length()];
        // In this loop we set base case , i.e , answers for substrings of len=1 and len=2
        for(int i =0; i<n; i++)
        {
            dp[i][i] = true;
            if(i<n-1)
            {
                dp[i][i+1] = false;
                if(str[i]==str[i+1])
                {
                    dp[i][i+1] = true;
                    cnt++;
                }
                
            }
            
        }
        
        // DP array stores boolean value whether string between i,j is palindorme or not
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
                    cnt++;
                    
            }
        }
        return cnt;
    }
    public void view(boolean arr[][])
    {
        for(boolean a[]: arr)
            System.out.println(Arrays.toString(a));
    }
}