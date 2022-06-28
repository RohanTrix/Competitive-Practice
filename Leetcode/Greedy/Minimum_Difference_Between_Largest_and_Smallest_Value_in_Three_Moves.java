public class Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {
    // IDEA : Same as in Discuss section.
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int n = nums.length;
        if(nums.length <=4)
            return 0;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<4; i++)
        {
            int small = nums[i];
            int large = nums[n-4+i];
            mini = Math.min(mini, large - small);
        }
        return mini;
    }
}
