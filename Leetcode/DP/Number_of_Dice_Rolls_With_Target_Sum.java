package Leetcode.DP;

/**
 *      IDEA : DP STATE => dp[n][target] = Number of ways to make target with n elements remaining.
 * 
 *      T.C = O(n*target*k)
 *      S.C = O(n*target)
 */


public class Number_of_Dice_Rolls_With_Target_Sum {
    Long dp[][];
    int mod = (int)1e9+7;
    public long ways(int n, int target, int k)
    {
        if(n == 0) return target == 0?1:0;
        if(target<0) return 0;
        if(dp[n][target]!=null) return dp[n][target];
        
        long cnt = 0;
        
        for(int ch = 1; ch<=k; ch++)
        {
            cnt+=ways(n-1, target-ch, k);
            cnt%=mod;
        }
        return dp[n][target] = cnt;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Long[n+1][target+1];
        return (int)ways(n,target, k);
    }
}
