package Leetcode.Binary_Search;

class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        
        
        // First Binary Search - Finding First position of X
        int ans1 = -1, ans2 = -1;
        if( n==0) return new int[]{ans1,ans2};
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
            {
                ans1 = mid;
                r = mid-1;
            }
            else if(nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        
        // Second Binary Search - Finding Last position of X
        l = 0; r = n-1;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
            {
                ans2 = mid;
                l = mid+1;
            }
            else if(nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return new int[]{ans1,ans2};
        
    }
}
