public class Partition_Array_into_Disjoint_Intervals {
    public int partitionDisjoint(int[] nums) {
        int prefMax = nums[0];
        int n = nums.length;
        int suffMin[] = new int[n];
        suffMin[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--)
            suffMin[i] = Math.min(nums[i], suffMin[i+1]);
        
        for(int i = 0; i<n-1; i++)
        {
            prefMax = Math.max(prefMax, nums[i]);
            if(prefMax<=suffMin[i+1])
                return i+1;
        }
        return -1;
    }
}
