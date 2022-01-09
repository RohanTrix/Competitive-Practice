public class Minimum_Swaps_to_Group_All_1s_Together_II {
    // REFER:
    // https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/discuss/1677446/Fixed-Sliding-Window
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for(int i : nums) ones+=i;
        int[] arr = new int[2*n];
        for(int i =0; i<(2*n); i++) arr[i] = nums[i%n];
        
        int currsum = 0, finsum = 0;
        for(int i =0;i<ones;i++) currsum+=arr[i];
        finsum = ones-currsum;
        for(int i = 1; i<(2*n-ones+1); i++)
        {
            currsum-=arr[i-1];
            currsum+=arr[i+ones-1];
            finsum = Math.min(finsum, ones - currsum);
        }
        return finsum;
    }
}
