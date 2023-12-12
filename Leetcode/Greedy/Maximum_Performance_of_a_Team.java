package Leetcode.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * IDEA : We have the following eqn :
 * 
 *        (s1+s2+s3...sk) * min(e1, e2,....ek)
 *        
 *        
 *        We would like to maximise both parts of the eqn. But there is no ordering to the 2 lists. So we will first club them
 *        and sort in DECREASING order of efficiency.
 *        
 *        The most important greedy idea is the following :
 *        
 *        For some efficiency E,
 *        it would be best to take all the workers you can that have efficiency at
 *        least E
 *        AND choose highest k speeds.
 *        
 *        So we start traversing the engineers in decreasing order of effciency.
 *        Everytime we come at a new smaller effciency, we need to remove the smallest speed being considered (given by the pq)
 *        and add the speed of the current engineer. 
 *        One might think that for same e, if we have 2 speeds s1 and s2 where s1 > s2, then why we pop s1 and add s2? Isnt that worse?
 *        We do not need to worry whether this is a optimal replacement or not 
 *        because we have already considered the answer with speed s1 in the previous iteration
 */
public class Maximum_Performance_of_a_Team {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i)
            engineers[i] = new int[] { efficiency[i], speed[i] };

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k)
                totalSpeed -= pq.poll(); // layoff the one with min speed
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            res = Math.max(res, (totalSpeed * engineer[0])); // min efficiency is the efficiency of new engineer
        }

        return (int) (res % MOD);
    }
}