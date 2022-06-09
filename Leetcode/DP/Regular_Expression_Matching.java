/**
 *      IDEA : Solved Myslef :)
 *             
 * 
 */
public class Regular_Expression_Matching {
    Boolean dp[][];
    char s[], p[];
    public boolean valid(int i, int j)
    {
        if(i == s.length && j == p.length) return true;
        if(j == p.length) return false; // If pattern is over...but s is not..then no possible way left
        if(dp[i][j]!=null) return dp[i][j];
        
        if(j+1<p.length && p[j+1] == '*') // If the next character is a *
        {
            // If s is over but pattern is left. For example
            // s = "", 
            // p = "a*b*"  
            // We can take 0 a's and 0 b's to form s.
            if(i == s.length)
                dp[i][j] = valid(i,j+2);
            
            // If curr char matches....then we 2 cases
            // Case 1:
            //         s = "aa", p = "a*"
            //         consume current i and j remains at same place for possible future consumptions
            // Case 2:
            //         s = "a", p = "a*a"
            //         Stop the consumption of a* and move to next letter by j+=2 to consume the 2nd 'a' which is necessary
            else if(s[i] == p[j] || p[j] == '.')
                dp[i][j] = valid(i+1, j) || valid(i,j+2);
            
            // Curr char doesnt match so do not consume letter and skip the curr letter(and its repetitions).
            else
                dp[i][j] = valid(i,j+2);
        }
        else
        {
            // Next char is NOT a '*'
            if(i == s.length) // String has ended...but pattern has neccesarily consume something( not a * op, thats why). 
                dp[i][j] = false;
            
            // Check match of current char and get ans of remaining str and pat.
            else
                dp[i][j] = (s[i] == p[j] || p[j] == '.') && valid(i+1,j+1);
        }
        return dp[i][j];
    }
    public boolean isMatch(String str, String ptr) {
        s = str.toCharArray();
        p = ptr.toCharArray();
        dp = new Boolean[s.length+1][p.length+1];
        return valid(0,0);
    }
}
