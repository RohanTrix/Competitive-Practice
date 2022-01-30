package Leetcode.Miscellaneous;

public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);  // reverse the whole array
        reverse(nums, 0, k-1);  // reverse the first part
        reverse(nums, k, nums.length-1);  // reverse the second part
    }
    
        public void reverse(int[] nums, int l, int r) {
            while (l < r) {
                int tmp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = tmp;
            }
        }
}
