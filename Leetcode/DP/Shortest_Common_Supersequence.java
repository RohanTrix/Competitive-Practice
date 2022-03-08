package Leetcode.DP;

/*
    // Some visulalizations in OneNote too.
    IDEA: If both the strings end with the same char, then we only need to append that character once
          from the end.
          If the ending chars are not same, then we try appending one of them and then finding the
          best answer of the remaining strings. Similar logic to Edit Distance.
          So


          DP STATE: 
                    dp[i][j] = Length of shortest subsequence from which 
                               both s1[0..i],s2[0...j] can be made.
          
          DP TRANSITIION:

                    dp[i][j] = 1 + dp[i-1][j-1]                     if(s[i] == s[j])

                    dp[i][j] = 1 + MIN(dp[i-1,j], dp[i][j-1])       else


          Now that we have created our DP array, we can start from the last cell,
                1) If the chars at i, j match, then we add s[i] to str at end.
                2) If chars do not match, then we move to the cell with the lesser value
                   and add the char whose index just changed. What we are doing is adding
                   the character which has not other option than to be included in
                   string right now. Draw and understand better

          Solved on my own
*/


public class Shortest_Common_Supersequence {
    Integer dp[][];
    String s1, s2;
    public int minLength(int i, int j)
    {
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            dp[i][j] = minLength(i-1,j-1);
        else
            dp[i][j] = Math.min(minLength(i-1, j), minLength(i, j-1));
        return ++dp[i][j];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        s1 = str1; s2 = str2;
        dp = new Integer[len1][len2];
        
        minLength(len1-1, len2-1);
        
        int i = len1-1, j = len2-1;
        StringBuilder s = new StringBuilder();
        while(i>=0 && j>=0)
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                s.append(s1.charAt(i));
                i--;j--;
            }
            else
            {
                if(i==0)
                    s.append(s2.charAt(j--));
                else if(j==0)
                    s.append(s1.charAt(i--)); 
                else if(dp[i-1][j]<dp[i][j-1])
                    s.append(s1.charAt(i--));
                else
                    s.append(s2.charAt(j--));
            }
        }
        while(i>=0)
            s.append(s1.charAt(i--));
        while(j>=0)
            s.append(s2.charAt(j--));
        s.reverse();

        return s.toString();
    }
}
