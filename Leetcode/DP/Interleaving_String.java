/**
 * 
 *      IDEA : The idea is clearly DP since we want to try different configurations of interleaving(only if the configuration is possible)
 *             
 *             DP STATE : dp[i][j] = T/F whether s3 is made up of interleaving of s1[0...i-1] and s2[0...j-1]
 * 
 *             DP Trans : If chars in s1 are not fully consumed, then we can take consume i-1th char and and (i+j-1)th char in s3 if they match.
 *                        Similar idea for s2
 */

public class Interleaving_String
{
    Boolean dp[][];
    char s1[], s2[], s3[];
    public boolean canForm(int i, int j)
    {
        if(i == 0 && j == 0)
            return true;
        if(dp[i][j]!=null) return dp[i][j];
        boolean ans = false;
        if(i-1>=0 && s1[i-1] == s3[i+j-1])
            ans = ans || canForm(i-1, j);
        if(j-1>=0 && s2[j-1] == s3[i+j-1])
            ans = ans || canForm(i,j-1);
        return dp[i][j] = ans;
    }
    public boolean isInterleave(String str1, String str2, String str3) {
        s1 = str1.toCharArray(); int l1 = s1.length;
        s2 = str2.toCharArray(); int l2 = s2.length;
        s3 = str3.toCharArray(); int l3 = s3.length;
        if(l3!=l1+l2)
            return false;
        dp = new Boolean[s1.length+1][s2.length+1];
        return canForm(l1, l2);
    }
}