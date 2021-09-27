package Leetcode.DP;

import java.util.*;
class Solution2{
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for(int i =1; i<size;i++)
        {
            dp[i] = 1;
            for(int j = 0; j<i; j++)
            {
                 // Not choosing ith element in seq
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1); 
            }
        }
        int maxi = -1;
        for(int i:dp) maxi = Math.max(i,maxi);
        //System.out.println(Arrays.toString(dp));
        return maxi;
    }
} // O(N^2)

public class Longest_Increasing_Subsequence {
    static int upper_bound(ArrayList<Integer> arr, int key)
    {
        // Largest value less than or equal to key
        int left = 0, right = arr.size()-1;
        int pos = -1;
        while(left<=right)
        {
                int mid = left +(right-left)/2;
                if(arr.get(mid) >= key)
                {
                    pos = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
        }
        return pos;
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sol = new ArrayList<>();
        for(int  currNum: nums)
        {
            if(sol.size()==0 || currNum > sol.get(sol.size()-1))
            {
                sol.add(currNum);
            }
            else
            {
                int pos = upper_bound(sol, currNum);
                sol.set(pos,currNum);
            }
        }
        return sol.size();
    }
} // O(N LogN)