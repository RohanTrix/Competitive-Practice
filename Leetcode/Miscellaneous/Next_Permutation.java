class Solution {
    // REFER :- https://youtu.be/DqsEe0wkL8g
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1) return; // Corner Case
        int pos = -1;
        // Going from right to left, finding the first pair which is strictly decreasing
        for(int i = n-2;i>=0; i--)
        {
            if(nums[i]<nums[i+1])
            {
                pos = i;
                break;
            }
        }
        if(pos==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int mini = Integer.MAX_VALUE;
        int min_pos = -1;
        for( int i = n-1;i>pos;i--)
        {
            if (nums[i]>nums[pos])
            {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                
                //REVERSING ARRAY
                int start = pos+1, end = n-1;
                while (start < end)
                {
                    temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
                break;
            }
        }
        
        
    }
}