package Leetcode.DP;

import java.util.Arrays;

/**
 * IDEA : The problem is to find the min number of elements to renlongest
 * mountain array. Mountain array can be thought of as
 * a array with a strict increasing sequence followed by a strict decreasing sequence.
 * Thus, we can think of using LIS and LDS to find the longest increasing and decreasing sequence upto an element.
 * Now, at every index, we calc the LIS + LDS - 1 length at that index, and find the max of all such lengths.
 * The subtraction of 1 is done because the element at that current index is counted twice.
 * 
 */

public class Minimum_Number_of_Removals_to_Make_Mountain_Array {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // Making Longest Inc DP
        int longestIncDp[] = new int[n];
        Arrays.fill(longestIncDp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    longestIncDp[i] = Math.max(longestIncDp[i], 1 + longestIncDp[j]);
            }
        }
        // Making Longest Dec DP
        int longestDecDp[] = new int[n];
        Arrays.fill(longestDecDp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j])
                    longestDecDp[i] = Math.max(longestDecDp[i], 1 + longestDecDp[j]);
            }
        }

        // Checking every index for Longest Mountain Array
        // Don't need to check for 0 and n-1 as they can't be the peak of a mountain

        int maxi = Integer.MIN_VALUE / 2;
        for (int i = 1; i < n - 1; i++) {
            if (longestIncDp[i] > 1 && longestDecDp[i] > 1)
                maxi = Math.max(maxi, longestIncDp[i] + longestDecDp[i] - 1);
        }

        return n - maxi;
    }
}
