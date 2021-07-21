package Leetcode.DP;

import java.util.*;

/* IDEA:

        * If we choose to select an item, we might as well pick up all occurences of that item.
        * Hence we build a frequency map for all the items
        * Next we can think of dp, and following are the states of the dp
        * We will traverse uptil the MAX(freq map's keys).
        *The dp states will depend on which element we take and whether we take it or not

            -> dp[i][0] denotes the maximum points we can acheive by not deleting the ith element
            -> dp[i][1] denotes the maximum points we can acheive by deleting the ith element
        
        * After the states are defined, the following transition can be derived

            1) dp[i][0] = MAX( dp[i-1][0], dp[i-1][0]) 

            --> meaning if ith element is not deleted, the maximum of the points by deleting or not deleting
                the previous element can be taken
            
            2) dp[i][1] = i * freq(i) + dp[i-1][0]

            --> meaning if ith element is deleted, we first add points we get from 
                the number of i's present(i*freq(i)).....and then add i-1's dp value when we do not delete i-1.
                Also, if i was not present in the original array, then freq(i) would be 0.

*/

public class Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
       
        int max = Collections.max(hm.keySet());
        int dp[][] = new int[max+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i<=max;i++)
        {
            // Not taking ith element
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //Taking ith element
            dp[i][1] = (i*hm.getOrDefault(i,0)) + dp[i-1][0];
        }
        return Math.max(dp[max][0], dp[max][1]);
        
    }
}
