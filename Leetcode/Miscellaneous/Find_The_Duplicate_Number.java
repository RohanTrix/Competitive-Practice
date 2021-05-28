package Leetcode;

// O(1) extra space
class Find_The_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        
        for(int i = 0; i< nums.length;i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                return Math.abs(nums[i]);
            else
                nums[index] = -nums[index];
            
                
        }
        return nums[0];
    }
}


