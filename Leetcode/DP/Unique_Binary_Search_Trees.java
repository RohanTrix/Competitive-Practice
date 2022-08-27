public class Unique_Binary_Search_Trees
{
    Integer dp[][];
    public int count(int l, int r)
    {
        if(l > r) return 1;
        if(dp[l][r] != null) return dp[l][r];
        int cnt = 0;
        for(int mid = l; mid<=r; mid++)
        {
            int left = count(l, mid - 1);
            int right = count(mid + 1, r);
            cnt+=(left*right);
        }
        return dp[l][r] = cnt;
    }
    public int numTrees(int n) {
        dp = new Integer[n+1][n+1];
        return count(1, n);
    }
}