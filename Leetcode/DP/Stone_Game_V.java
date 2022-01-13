/*
    Classic Simple DnC DP:
    Note: Bob is of no use for this game and since we have only one player Alice, we do not have to
          store which player is playing unlike other Stone games
    DP STATE:
            dp[i][j] = Max Score we get from the range i..j

    DP Transition:
            For every partition point p(i<=p<j), we basically do what is asked using Prefix Sums:
                If left sum is lesser, we add it to currScore and call answer for right half
                If right sum is lesser, we add it to currScore and call answer for left half
                If both are equal, we take the one which gives MAX score.
                Finally, we take best score of all these partitions 
*/
public class Stone_Game_V {
    int pref[];
    int dp[][];
    public int bestScore(int i, int j)
    {
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int currScore = 0;
        for(int p = i; p<j; p++)
        {
            int left = pref[p] - pref[i-1];
            int right = pref[j] - pref[p];
            
            if(left<right)
                currScore = left + bestScore(i,p);
            else if(left>right)
                currScore = right + bestScore(p+1,j);
            else
                currScore = left + Math.max(bestScore(i,p), bestScore(p+1,j));
            
            dp[i][j] = Math.max(dp[i][j], currScore);
        }
        return dp[i][j];
    } 
    public int stoneGameV(int[] stoneValue) {
        calcPrefix(stoneValue);
        int n = stoneValue.length;
        dp = new int[n+1][n+1];
        for(int a[]: dp) Arrays.fill(a, -1);
        return bestScore(1, n);
        
    }
    public void calcPrefix(int arr[])
    {
        int n = arr.length;
        pref = new int[n+1];
        for(int i = 1; i<=n; i++)
            pref[i] = pref[i-1] + arr[i-1];
    }
}
