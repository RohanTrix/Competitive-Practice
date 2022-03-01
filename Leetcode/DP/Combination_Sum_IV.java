package Leetcode.DP;

/*
    IDEA : We first sort the array, so that if a coin is larger than than required sum, then we 
           skip that and all after that.
           Now,

        DP STATE : dp[tar] = Number of ways to make target = tar
        DP Transition : dp[tar] = dp[tar-c1] + dp[tar-c2]......Where ci belongs to coins
*/
public class Combination_Sum_IV {
    Integer dp[];
    public int count(int sum, int nums[])
    {
        if(sum == 0) return 1;
        if(dp[sum]!=null) return dp[sum];
        int cnt = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(sum-nums[i]<0) break;
            cnt+=count(sum-nums[i], nums);
        }
        return dp[sum] = cnt;
    }
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new Integer[target+1];
        return count(target, nums);
    }
}
