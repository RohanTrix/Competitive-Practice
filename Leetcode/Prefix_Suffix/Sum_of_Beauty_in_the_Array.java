public class Sum_of_Beauty_in_the_Array {
    // IDEA : Keep prefix Max and Suffix Min.
    //        If prefMax is lesser than current, all elements before current are lesser.
    //        If suffMin is larger than current, all after current are larger.
    public int sumOfBeauties(int[] nums) {
        int prefMax = nums[0];
        int n = nums.length;
        int suffMin[] = new int[n];
        suffMin[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--)
            suffMin[i] = Math.min(nums[i], suffMin[i+1]);
        int sum = 0;
        for(int i =1; i<n-1; i++)
        {
            if(prefMax<nums[i] && nums[i] < suffMin[i+1])
                sum+=2;
            else if(nums[i-1]<nums[i] && nums[i] < nums[i+1])
                sum++;
            prefMax = Math.max(prefMax, nums[i]);
        }
        return sum;
    }
}
