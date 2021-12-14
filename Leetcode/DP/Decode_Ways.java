/*
    Idea: Since for multiple partions of the string, the remaining partitions are common, hence
          this problem can be solved using DP. Here is the DP idea:

          DP STATE: 
            
            dp[i] = the number of valid ways to decode the message str[i.....n]
        
          DP TRANSITIONS (with quite a few corner cases):

            dp[i] = dp[i+1] + dp[i+2]

    Rest explanation in between code
*/

public class Decode_Ways
{
    int dp[];
    public int recur(char str[], int i)
    {
        // Reaching empty string means we have successfully partitioned once
        if(i==str.length)
            return 1;
        // If the last char is left, it is only possible to partition it if it is non-zero
        if(i==str.length-1)
            return (str[i]!='0')?1:0;
        
        // Return dp value if stored
        if(dp[i]!=-1)return dp[i];
        
        
        dp[i] = 0; // Setting to zero as initially no ways found

        // On calling recur(str, i+1) or basically considering str[i],
        // it needs to be checked str[i] is not '0'
        // as '0' has no decoded value
        if(str[i]!='0')
        {
            dp[i] = recur(str, i+1);

            // On calling recur(str, i+2), 
            // so we should check str[i..i+1] < "27" as only then it can be a valid decoding.
            if("27".compareTo((""+str[i]+str[i+1])) > 0)
                dp[i]+=recur(str, i+2);
            
        }
        return dp[i];   // Return ans 
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        char str[] = s.toCharArray();
        dp = new int[str.length];
        Arrays.fill(dp,-1);
        return recur(str, 0);
    }
}