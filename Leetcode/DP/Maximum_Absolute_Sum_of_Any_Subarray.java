public class Maximum_Absolute_Sum_of_Any_Subarray {
    // Max of Kadanes of normal array and array with all values negated.
    // Basically getting min subarray and max subarray...and returning the maximum abs of both.
    public int maxAbsoluteSum(int[] nums) {
        if(nums.length == 0) return 0;
        int maxEndHere1 = 0, maxSoFar1 = Integer.MIN_VALUE/2;
        int maxEndHere2 = 0, maxSoFar2 = Integer.MIN_VALUE/2;
        for(int num : nums)
        {
            maxEndHere1+=num;
            maxEndHere2+=(-num);
            maxEndHere1 = Math.max(maxEndHere1, num); // Normal Element
            maxEndHere2 = Math.max(maxEndHere2, -num); // Element with sign reversed
            maxSoFar1 = Math.max(maxSoFar1, maxEndHere1);
            maxSoFar2 = Math.max(maxSoFar2, maxEndHere2);
        }
        return Math.max(maxSoFar1, maxSoFar2);
    }
}
