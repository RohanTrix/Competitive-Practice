public class Minimum_Moves_to_Equal_Array_Elements_II {
    // Answer is distance of all other elements to median
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n/2];
        int sum = 0;
        for(int num : nums) sum+=Math.abs(median - num);
        return sum;
    }
}
