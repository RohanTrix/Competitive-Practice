public class Minimum_Operations_to_Reduce_X_to_Zero 
{
    //Sliding window Approach
    //Finding a sum of values from ends to be equal to x is nothing  
    // but finding a subarray (longest in our case to minimise the steps) equal to totalSum - x
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum() - x;
        int left=0,curr_sum = 0, max_length = -1;
        for(int right=0; right < n; right++)
        {
            curr_sum += nums[right];
            while(curr_sum > target && left<=right )
                curr_sum -=nums[left++];
            if( curr_sum == target)
                max_length = Math.max( max_length, right-left+1);
        }
        return (max_length!=-1)?n-max_length : -1 ;
    }
}
