import java.util.Collections;
import java.util.PriorityQueue;

class Put_Marbles_in_Bags {
    // REFER : https://youtu.be/UB1Q3TKvY3Y
    public long putMarbles(int[] nums, int k) {
        k--;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i<n-1; i++) {
            pq.offer(nums[i]+nums[i+1]);
            if(pq.size() > k) pq.poll();
        }
        long maxSum = 0;
        while(!pq.isEmpty())
            maxSum+=pq.poll();
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n-1; i++) {
            pq.offer(nums[i]+nums[i+1]);
            if(pq.size() > k) pq.poll();
        }
        long minSum = 0;
        while(!pq.isEmpty())
            minSum+=pq.poll();
        return maxSum - minSum;

    }
}