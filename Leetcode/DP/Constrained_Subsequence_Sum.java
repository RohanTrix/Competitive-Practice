package Leetcode.DP;

public class Constrained_Subsequence_Sum {
    // REFER: https://youtu.be/B0tkLWBhmwA
    // DP STATE : dp[i] = Max Sum with subsequence ending at ith
    
    // DP TRANSITION: dp[i] = MAX(dp[i-k-1]....dp[i-1],0) + nums[i]
    
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        
        int dp[] = new int[n];
        Arrays.fill(dp,0);
        int maxi = Integer.MIN_VALUE;
        for(int i  = 0; i<nums.length; i++)
        {
            if(i>k && q.peekFirst() == dp[i-k-1])
                q.pollFirst();
            
            if(!q.isEmpty())
                dp[i] = q.peekFirst();
            
            dp[i] = Math.max(dp[i],0)+ nums[i];

            while(!q.isEmpty() && q.peekLast() < dp[i])
                q.pollLast();
            q.offerLast(dp[i]);
            
            maxi = Math.max(dp[i], maxi);
        }
        return maxi;
        
    }
}
