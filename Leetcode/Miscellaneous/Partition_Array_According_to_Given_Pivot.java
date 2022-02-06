/*
        IDEA: We will need 3 traversals of full array.
            1) In first traversal, we place all elements strictly smaller than pivot.
            2) In second traversal, we start from the last position variable j reached and fill spaces with elements equal to pivot
            3) In third traversal, we place all elements strictly larger than pivot.
*/
public class Partition_Array_According_to_Given_Pivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[] = new int[nums.length];

        int j = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i]<pivot)
            ans[j++] = nums[i];
        }
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == pivot)
                ans[j++] = nums[i];
        }
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] > pivot)
                ans[j++] = nums[i];
        }
        return ans;
    }
}
