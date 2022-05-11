/*
    IDEA : dp[n][ind] = No. of lexicographic sorted combinations with n letters left and current vowel as
                        ind'th vowel
*/
public class Count_Sorted_Vowel_Strings {
    Integer dp[][];
    public int dfs(int n, int ind)
    {
        if(n == 0) return 1;
        if(ind == 5) return 0;
        if(dp[n][ind]!=null) return dp[n][ind];
        return dp[n][ind] = dfs(n-1, ind) + dfs(n,ind+1);
    }
    public int countVowelStrings(int n) {
        dp = new Integer[n+1][5];
        return dfs(n, 0);
    }
}