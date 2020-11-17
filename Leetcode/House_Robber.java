public class House_Robber {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==0)
            return 0;
        
        else if(n==1)
            return nums[0];
        
        else if( n==2)
            return Math.max(nums[0],nums[1]);
        
        else
        {
            int maxSum[] = new int[n];
            maxSum[0] = nums[0];
            maxSum[1] = Math.max(nums[0],nums[1]);
            for(int i=2;i<n;i++)
            {
                 maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + nums[i]);
            }
            return maxSum[n-1];
        }
    }
}