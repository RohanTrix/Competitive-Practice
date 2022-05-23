public class Ones_and_Zeroes
{
    /* IDEA :
                DP STATE => dp[i][m][n] =  Max size of subset chosen starting from i with m zeros and n ones available to add
                DP TRANSITION : 01 Knapsack like transition
                
    */
    Integer dp[][][];
    int N;
    int INT_MIN = Integer.MIN_VALUE/2;
    public int findMaxSize(int i, int m, int n, int cnt[][])
    {
        if(m<0 || n<0) return INT_MIN;
        if(i == N) return 0;
        if(dp[i][m][n]!=null) return dp[i][m][n];
        
        return dp[i][m][n] = Math.max(1+findMaxSize(i+1, m-cnt[i][0], n-cnt[i][1], cnt), findMaxSize(i+1, m, n, cnt));
        
    }
    public int findMaxForm(String[] strs, int m, int n) {
        N = strs.length;
        int cnt[][] = new int[N][2];
        for(int i = 0; i<N; i++)
            for(char ch : strs[i].toCharArray())
                cnt[i][ch-'0']++;
        dp = new Integer[N][m+1][n+1];
        return findMaxSize(0, m, n, cnt);
    }
}