public class Kth_Largest_Element_in_an_Array
{
    // REFER QuickSort : https://youtu.be/COk73cpQbFQ
    // REFER QuickSelect : https://youtu.be/va1rSWdq6JY
    public int partition(int left, int right, int nums[])
    {
        // Descending order partitioning
        int pi = left;
        // pi = partitionIndex
        for(int i = left; i<right; i++)
        {
            if(nums[i] >= nums[right])
            {
                int tmp = nums[i];
                nums[i] = nums[pi];
                nums[pi++] = tmp;
            }
        }
        int tmp = nums[right];
        nums[right] = nums[pi];
        nums[pi] = tmp;

        return pi;
    }
    public int findKthLargest(int[] nums, int k) {
        k--;
        // QuickSelect
        int left = 0, right = nums.length-1;
        do
        {
            int pi = partition(left, right, nums);
            if(pi == k) return nums[pi];
            else if(pi>k)
                right = pi-1;
            else
                left = pi+1;
        }while(left<=right);
        return -1;
    }
}