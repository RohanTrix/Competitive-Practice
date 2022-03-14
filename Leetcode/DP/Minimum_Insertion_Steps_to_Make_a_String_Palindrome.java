/*
    IDEA : The problem is clearly DP because its a minimization problem.
           Start thinking from string end points. ANd then make cases.
           DP STATE: dp[i][j] = Min cost/insertions to make s[i...j] palindrome.

           DP TRANS: dp[i][j] =   dp[i+1][j-1]                      If s[i] == s[j]
                     
                                 Math.min(dp[i+1][j], dp[i][j-1])  + 1   If s[i] != s[j]
                                 
                                 This means we take min of
                                 either insert a char on right which matches ith or insert a char on left
                                 which matches jth. So one move for placing either of the chars, and mini
                                 of both the strings which remain after adding on either side.

*/
public class Minimum_Insertion_Steps_to_Make_a_String_Palindrome {
    Integer dp[][];
    char str[];
    public int minCost(int i, int j)
    {
        if(i == j || i+1==j) return str[i] == str[j]?0:1;
        if(dp[i][j]!=null) return dp[i][j];
        
        if(str[i] == str[j]) return dp[i][j] = minCost(i+1, j-1);
        
        return dp[i][j] = 1 + Math.min(minCost(i+1, j), minCost(i, j-1));
    }
    public int minInsertions(String s) {
        str = s.toCharArray();
        dp = new Integer[s.length()][s.length()];
        return minCost(0,s.length() - 1);
    }
}
