public class Shortest_Subarray_with_Sum_at_Least_K {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();
        
        long pref[] = new long[n+1];
        for(int i=1; i<=n; i++) 
            pref[i] = pref[i-1] + nums[i-1];
        
        
        for(int right = 0; right <=n; right++)
        {
            
            while(!queue.isEmpty() && pref[right] - pref[queue.peekFirst()] >=k)
                ans = Math.min(ans, right - queue.pollFirst());

            while(!queue.isEmpty() && pref[queue.peekLast()] >= pref[right])
                queue.pollLast();
            queue.offerLast(right);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
