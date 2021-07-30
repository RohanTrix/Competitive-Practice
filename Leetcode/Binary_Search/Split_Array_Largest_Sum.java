package Leetcode.Binary_Search;


import java.util.stream.*;
class Split_Array_Largest_Sum {
    public boolean possible(int nums[], int maxCap, int maxSubArrNum)
    {
        int total = 0;
        int subArrNum = 1;
        for(int i = 0;i<nums.length;i++)
        {
            total+=nums[i];
            if(total>maxCap)
            {
                total = nums[i];
                subArrNum++;
            }   
        }
        return subArrNum<=maxSubArrNum;
    }
    public int splitArray(int[] nums, int m) {
        int bestans = -1;
        
        int l = IntStream.of(nums).max().getAsInt();
        int r = IntStream.of(nums).sum();
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(possible(nums, mid, m))
            {
                bestans = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }
        return bestans;
    }
}