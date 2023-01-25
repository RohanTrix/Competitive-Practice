package Leetcode.DP;

import java.util.HashMap;
import java.util.Map;

/**  IDEA : We need to query for a subarray what is the trimmed value of it. Since teh constraints are just <=1000,
 *          we can pre process and store this in O(n^2). We go at every starting point, then use a HashMap and a 2nd pointer j
 *          moving forward. Now, we want to calc no. of values which occur more than once in the subarray [i..j],
 *          which is nothing but (j-i+1) - (Count of vals with freq = 1). We do this in one pass for each starting point
 *          and build UNIQUE_CNT matrix.
 * 
 *          Now, after this preprocessing, we make a DP minCost(i) ===> Min cost of splitting subarray starting from i
 *          We partition at every point from i and get minimum partition out of all.

*/
public class Minimum_Cost_to_Split_an_Array {
    int UNIQUE_CNT[][];
    int nums[], k, n;
    Integer dp[];
    public int minCost(int i)
    {
        if(i == n) return 0; 
        if(dp[i]!=null) return dp[i];
        int cost = Integer.MAX_VALUE/2;
        for(int p = i; p<n; p++)
            cost = Math.min(cost, UNIQUE_CNT[i][p] + k + minCost(p+1));
        return dp[i] = cost; 
    }
    public int minCost(int[] nums, int k) {
        this.nums = nums; this.k = k;
        n = nums.length;
        UNIQUE_CNT = new int[n][n];
        dp = new Integer[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            map.clear();
            int cnt = 0;
            for(int j = i; j<n; j++)
            {
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
                if(map.get(nums[j]) == 1) cnt++;
                if(map.get(nums[j]) == 2) cnt--;
                UNIQUE_CNT[i][j] = (j-i+1) - cnt;
            }
        }
        return minCost(0);    
    }
}
