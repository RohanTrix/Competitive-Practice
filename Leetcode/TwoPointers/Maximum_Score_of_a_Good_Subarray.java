package Leetcode.TwoPointers;

/*
    IDEA : Since we have been given a k and we need to find a subarray containing k,
           to denote the subarray, we need 2 pointers. So the intuition to using 2 pointers was clear.

           The idea is :
                Using 2 pointers, every time we increase the window size, we would want out
                minimum to be as high as possible. So we choose to extend in the direction where 
                the higher number in present among left and right.

*/
public class Maximum_Score_of_a_Good_Subarray {
    public int maximumScore(int[] nums, int k) {
        int left = k,right = k;
        int finAns = nums[k];
        int mini = nums[k];
        int n = nums.length;
        while(left>0 && right<n-1)
        {
            if(nums[left-1] >= nums[right+1])
                
            {
                left--;
                mini = Math.min(mini, nums[left]);
            }
            else
            { 
                right++;
                mini = Math.min(mini, nums[right]);
            }
            finAns = Math.max(finAns, mini*(right-left+1));
            
        }

        while(left>0)
        {
            left--;
            mini = Math.min(mini, nums[left]);
            finAns = Math.max(finAns, mini*(right-left+1));
            
        }
        while(right<n-1)
        {
            right++;
            mini = Math.min(mini, nums[right]);
            finAns = Math.max(finAns, mini*(right-left+1));
            
        }
        return finAns;
    }
}
