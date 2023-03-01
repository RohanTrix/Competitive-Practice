package Leetcode.Sliding_Window;

/**
 * IDEA : Sliding Window can be used to count number of subarrays with oddcnt<=k
 *         
 *        cntOfSubarrays(oddcnt = k) ===== cntOfSubarrays(oddcnt <= k) - cntOfSubarrays(oddcnt <= k-1)
 */

public class Count_Number_of_Nice_Subarrays {
    public int atmostK(int nums[], int k)
    {
        int left = 0, oddcnt = 0, n = nums.length;
        int ans = 0;
        for(int right = 0; right<n; right++)
        {
            if(nums[right]%2!=0) oddcnt++;
            
            while(left<=right && oddcnt>k)
            {
                oddcnt-=(nums[left++]%2!=0)?1:0;
            }
            
            // Every element in the window upto right is a subarray with oddcnt <=k

            ans+=(right-left+1); // Adding count of subarrays ending at right with <=k odd numbers
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atmostK(nums, k) - atmostK(nums, k-1);
    }
}
