
// IDEA : Since we want to minimise the sum of pairs, we want to pair up the smallest with largest,
//        then next smallest with next largest. Now, any one of these can be the max sum, so we take max of
//        all such pairs

public class Minimize_Maximum_Pair_Sum_in_Array {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxisum = Integer.MIN_VALUE;
        for(int i=0; i<n/2; i++)
        {
            maxisum = Math.max(nums[i]+nums[n-i-1], maxisum);
        }
        return maxisum;
    }
}
