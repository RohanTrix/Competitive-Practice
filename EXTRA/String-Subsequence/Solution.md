```java
class Solution {
    int countWays(String S1, String S2) { 
        // code here 
        String s1 = S2;
        String s2 = S1;
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
    
        for(int i = 0; i<=n; i++) dp[0][i] = 1; // Ways to make empty subseq from any strng is 1
        for(int i = 1; i<=m; i++) dp[i][0] = 0; // Ways to make non-empty subseq from empty subseq is 0
        
        for(int i  = 1; i<=m; i++) // Loop over pattern letters
        {
           
            for(int j = 1; j<=n; j++)
            {
                // Draw table, take example and understand
                /*
                If the current character of both string and pattern matches,
                    1. Exclude current character from both string and pattern
                    2. Exclude only the current character from the string

                Otherwise, if the current character of the string and pattern do not match,
                exclude the current character from the string
                
                */
                if(s1.charAt(i-1)==s2.charAt(j-1))
                   dp[i][j] = dp[i-1][j-1];
                else
                   dp[i][j] = 0;
                
                dp[i][j]+=dp[i][j-1]; 

                
            }
           
        }

        return dp[m][n];
    }
}
```

![](https://i.ibb.co/zmgX1KD/Capture.png")