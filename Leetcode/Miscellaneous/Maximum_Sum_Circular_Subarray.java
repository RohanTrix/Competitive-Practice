public class Maximum_Sum_Circular_Subarray
{
    // REFER : https://youtu.be/CGFohM-BkWM
    // IMP QUESTION
    public int getkadane(int nums[])
    {
        int maxEndHere = 0, maxSoFar = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++)
        {
            maxEndHere+=nums[i];
            maxSoFar = Math.max(maxSoFar, maxEndHere);
            maxEndHere = Math.max(maxEndHere, 0);
        }
        return maxSoFar;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];
        for(int i : nums) maxVal = Math.max(i, maxVal);
        int ans1 = getkadane(nums);
        for(int i = 0; i < n; i++) nums[i] = -nums[i];
        int ans2 = -getkadane(nums);
        for(int i = 0; i < n; i++) nums[i] = -nums[i];
        int sum = 0;
        for(int i : nums) sum+=i;
        boolean poscheck = false;
        for(int i : nums) if(i>0) poscheck = true;
        if(!poscheck) return maxVal;
        return Math.max(sum - ans2, ans1);
    }
}