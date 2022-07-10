public class Jump_Game_VI {
    public int maxResult(int[] nums, int k) {
        // REFER for Explanation : https://youtu.be/dHAsYTvbbj4
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i = 0; i<n; i++)
        {
            if(i>k && dp[q.peekFirst()] == dp[i-k-1])
                q.pollFirst();
            
            dp[i] = nums[i];
            if(!q.isEmpty()) dp[i]+=dp[q.peekFirst()];
            
            while(!q.isEmpty() && dp[q.peekLast()] < dp[i])
                q.pollLast();
            q.offerLast(i);
        }
        return dp[n-1];
    }
}
