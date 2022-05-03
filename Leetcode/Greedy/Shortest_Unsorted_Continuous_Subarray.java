// PREREQUISITE IDEA : Similar to Idea to Max Chunks to Make Sorted II

/*
    Build Prefix Max and Suffix Min
    We want to find the first position where the prefMax becomes bigger than the suffix max after it.
    This shows that an element exists to the right which is smaller than the max element in our prefix.

    We do a similar traversal from behind to get the last such index. This is the subarray
*/

public class Shortest_Unsorted_Continuous_Subarray
{
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int prefMax[] = new int[n];
        int suffMin[] = new int[n];
        prefMax[0] = nums[0];
        suffMin[n-1] = nums[n-1];
        boolean b = true;
        for(int i =0; i<n-1; i++) if(nums[i]>nums[i+1]) b = false;
        if(b) return 0;
        for(int i = 1; i<n; i++)
            prefMax[i] = Math.max(prefMax[i-1], nums[i]);
        
        for(int i = n-2; i>=0; i--)
            suffMin[i] = Math.min(suffMin[i+1], nums[i]);
        
        int ind1 = 0;
        for(int i = 0; i<n-1; i++)
        {
            if(prefMax[i]>suffMin[i+1])
            {
                ind1 = i; break;
            }
        }
        int ind2 = n-1;
        for(int i = n-2; i>=0; i--)
        {
            if(prefMax[i]>suffMin[i+1])
            {
                ind2 = i+1; break;
            }
        }
        return ind2-ind1+1;
    }
}