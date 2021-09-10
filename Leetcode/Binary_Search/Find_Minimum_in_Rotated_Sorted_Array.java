public class Find_Minimum_in_Rotated_Sorted_Array
{
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int bestAns = nums[0];
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[0])
            {
                bestAns = nums[mid];
                r = mid-1;
            }
            else
                l = mid+1;
        }
        return bestAns;
    }
}