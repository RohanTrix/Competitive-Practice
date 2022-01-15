package Leetcode.Greedy;

// REFER : https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy

public class Jump_Game_II {
    public int jump(int[] nums) {
        int jumps = 0;
        int n = nums.length;
        int bestPosCanReach = 0;
        int currEnd = 0;
        for(int i =0; i<n-1;i++)
        {
            bestPosCanReach = Math.max(bestPosCanReach, nums[i]+i);
            if(i==currEnd)
            {
                jumps++;
                currEnd = bestPosCanReach;
            }
        }
        return jumps;
    }
}
