package Leetcode.Sliding_Window;

/* Idea: 
        The right pointer moves and adds current element to the currSum. Now we try to decrease
        window size( and the currSum) and stop till we cannot meet the currSum>=k condition.
        If the currSum>=k, we record the length of the window if it is smaller than bestLen.
*/

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, currSum = 0;
        int bestLen = Integer.MAX_VALUE/2;
        for(int right = 0; right<n; right++)
        {
            currSum+=nums[right];
            
            while(left<=right && currSum>=target )
            {
                if(currSum-nums[left]<target)
                    break;
                currSum-=nums[left++];
            }
            if(currSum>=target)
                bestLen = Math.min(bestLen, right-left+1);
            
        }
        return (bestLen==Integer.MAX_VALUE/2)?0:bestLen;
    }
}