class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        int n = nums.length;
        if(sum%2!=0) return false; // odd sum cannot be partitioned in half
        // Breaks to finding a subset sum problem where new sum = sum/2
        sum/=2;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 1;i<= sum; i++) 
            dp[0][i] = false;
        for(int i =0;i<=n;i++)
            dp[i][0] = true;
        for(int currNum = 1;currNum<=n;currNum++)
        {
            for(int currSum =1; currSum<=sum;currSum++)
            {
                int ind = currNum-1;
                dp[currNum][currSum] = dp[currNum-1][currSum];// Not including current number
                if(nums[ind]<=currSum)
                    dp[currNum][currSum] = dp[currNum][currSum] || dp[currNum-1][currSum-nums[ind]]; 
                    //Including number condition OR with not including condition
                
            }
        }
        return dp[n][sum];
        
    }
}