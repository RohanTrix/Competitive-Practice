class Solution {
    //REFER https://www.thealgorists.com/Algo/DynamicProgramming/01Knapsack/TargetSum
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if (target > sum || target < -sum) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1]; // dp[i] = number of unique subsets that sum up to i
        dp[0] = 1; // dp[0] is initially 0 (before iterating the array) 
        // since we can get 0 by having an empty subset.
        // Eventually it gets updated as we iterate over the array if
        // we happen encounter one or more subset(s) giving zero
        for (int i = 0; i < nums.length; i++) {
            for (int weight = subsetSum; weight >= nums[i]; weight--) {
                dp[weight] += dp[weight - nums[i]];
            }
        }
        return dp[subsetSum];
    }
}