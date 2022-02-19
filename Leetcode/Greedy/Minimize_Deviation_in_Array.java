package Leetcode.Greedy;

/*
    REFER : https://youtu.be/u0n-6zBnohY
*/
public class Minimize_Deviation_in_Array {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i]%2!=0)
                nums[i]*=2;
            pq.add(nums[i]);
            mini = Math.min(mini, nums[i]);
        }
        int minDev = Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int curr = pq.poll();
            minDev = Math.min(curr-mini, minDev);
            if(curr%2!=0)
                break;
            else
                mini = Math.min(mini, curr/2);
            pq.add(curr/2);
        }
        return minDev;
    }
}
