package Leetcode.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Maximal_Score_After_Applying_K_Operations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) pq.offer(num);
        long score = 0;
        while(k>0)
        {
            score+=pq.peek();
            int ceil = (pq.poll()+2)/3;
            pq.offer(ceil);
            k--;
        }
        return score;
    }
}
