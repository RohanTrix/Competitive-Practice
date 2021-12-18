import java.util.*;

// TWO APPROACHES DISCUSSED

class Word_Break1

{
    /*
     * IDEA : DIVIDE AND CONQUER DP 
     *          dp[i][j] = 1/0 such that s[i:j] can be formed by breaking the words
     * 
     *          Given a String, we try partition it at every point and send each half to check 
     *          for possibility of it being formed by multiple words in the dict. If both halfs
     *          are possible to be broken for any partition point
     *          then we store answer for s[i:j] as 1(true) else 0(false)
     */

    Set<String> dict;
    int dp[][];

    public int possible(String s, int i, int j) {

        if (i > j)
            return -1;

        if (i == j)
            return (dict.contains(s.substring(i, j + 1))) ? 1 : 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (dict.contains(s.substring(i, j + 1)))
            return 1;
        for (int p = i; p < j; p++) {
            int left = possible(s, i, p);
            int right = possible(s, p + 1, j);
            if (left == 1 && right == 1)
                return dp[i][j] = 1;
        }
        return dp[i][j] = 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        dp = new int[len][len];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        // for(String w: wordDict)dict.add(w);
        dict = new HashSet<String>(wordDict);
        int ans = possible(s, 0, len - 1);
        return (ans == 1) ? true : false;
    }
}

public class Word_Break {

    /*
     * IDEA : DP with Partion only if valid 
     *          dp[i] = 1/0 such that s[i:n] can be formed by breaking the words
     * 
     *          Given a String, we will only partion it if the left half is a valid word.
     *          This can be done by appending pth char at every partition point and checking
     *          if a valid string is being is formed. If yes, then we recur to check if right
     *          half can be formed by breaking it into 0 or more partitions
     */
    Set<String> dict;
    int dp[];
    public int possible(String s, int i)
    {
        if(i == s.length())return 1;
        if(dp[i]!=-1) return dp[i];
        
        if(dict.contains(s.substring(i)))return 1;
        
        StringBuilder str = new StringBuilder();
        for(int p = i; p<s.length()-1; p++)
        {
            str.append(s.charAt(p));
            if(dict.contains(str.toString()))
            {
                if(possible(s,p+1)==1) return dp[i] = 1;
            }
        }
        return dp[i] = 0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        dp = new int[len];
        Arrays.fill(dp,-1);
        dict = new HashSet<String>(wordDict);
        int ans = possible(s,0);
        return (ans==1)?true:false;
    }
}