public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {

        // REFER : https://youtu.be/Whhpvk2k5qk
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            while(nums[i]>0 && nums[i]<=n && nums[i]!= nums[nums[i] - 1]) 
            {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }

            //System.out.println(Arrays.toString(nums));
        }
        for(int i = 0; i<n; i++)
            if(nums[i]!=i+1) 
                return i+1;
        return n+1;
    }
}
