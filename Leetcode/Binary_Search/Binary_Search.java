package Leetcode.Binary_Search;


class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1 ,mid;
        while(left<=right)
        {
            mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if( target > nums[mid] )
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}