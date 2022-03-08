// Without array modification O(1);
class Find_The_Duplicate_Number
{
    // REFER : https://youtu.be/32Ll35mhWg0   slow and fast pointer logic
    public int findDuplicate(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = 0;
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}


// O(1) extra space but array modified
class Find_The_Duplicate_Number1 {
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


