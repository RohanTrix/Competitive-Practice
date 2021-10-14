package Leetcode.DP;

public class House_Robber_II {

    // REFER :- https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation/61006
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0],nums[1]);
        dp2[1] = nums[1];
        for(int i = 2;i<nums.length-1;i++)
        {
            dp1[i] = Math.max(dp1[i-1], nums[i]+dp1[i-2]);
        }
        for(int i = 2; i<nums.length;i++)
        {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[nums.length-2],dp2[nums.length-1]);
    }
}
