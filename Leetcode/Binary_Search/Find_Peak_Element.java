public class Find_Peak_Element
{
    // BINARY SEARCH FOR LAST HIGHEST POINT
    public int findPeakElement(int[] nums) {
        int l = 1, r = nums.length - 1;
        int ind = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid-1])
            {
                ind = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ind;
    }
}