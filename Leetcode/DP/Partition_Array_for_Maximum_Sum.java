/*
    IDEA : 
            DP STATE : dp[st] = Max of maxes taken from partions of arr[st...n]

            Follow Code to understand DP transition easily.
*/

public class Partition_Array_for_Maximum_Sum
{
    int dp[];
    int k;
    public int maxSum(int st, int arr[])
    {
        if(dp[st]!=-1)return dp[st];
        int run_max = Integer.MIN_VALUE/2;
        int res = Integer.MIN_VALUE/2;
        for(int i = st; i<(st+k) && i<arr.length; i++)
        {
            run_max = Math.max(run_max, arr[i]);
            res = Math.max(res, run_max*(i-st+1) + maxSum(i+1, arr));
        }
        return dp[st] = res;
    }
    public int maxSumAfterPartitioning(int[] arr, int K) {
        int len = arr.length;
        dp = new int[len+1];
        Arrays.fill(dp,-1);
        dp[len] = 0;
        k = K;
        return maxSum(0,arr);
    }
}