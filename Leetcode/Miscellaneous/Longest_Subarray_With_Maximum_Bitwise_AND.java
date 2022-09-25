package Leetcode.Miscellaneous;

// IDEA : For a subarray, AND <= MAX(subarray)....so we only find the longest subarray with all maxi

public class Longest_Subarray_With_Maximum_Bitwise_AND {
    public int longestSubarray(int[] nums) {
        
        int maxi = -1;
        for(int num : nums) maxi = Math.max(maxi, num);
        int cnt = 0, ans = 1;
        for(int num : nums)
        {
            if(num == maxi) cnt++;
            else cnt = 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
