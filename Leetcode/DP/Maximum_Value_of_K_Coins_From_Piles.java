package Leetcode.DP;
import java.util.*;

/*
 *      IDEA : The hint for DP came from the constraints and the fact that there could be multiple paths to acheiving the same k choices,
 *             hence we should define out own path.
 * 
 *             DP STATE : dp[i][k] = Max Coin Sum for piles[0...i] from which some (possibly 0) coins have been picked till now and k more left to pick
 *             
 *             NOTE: The solution, viewed naively, would seem to be of Time Complexity: O(n^2 * k). However, think about this:
 *                      For some [i][k], when we pick x(<=k) coins, then we have only k-x looping to be done for any of the other states.
 *                      So if we accumulate the looping time for all other i's, it will sum up to k
 * 
 *                    Hence TC = O(n * k)
 */

public class Maximum_Value_of_K_Coins_From_Piles {
    Integer dp[][];

    public int maxSum(int i, int k, List<List<Integer>> piles) {
        if (i == -1)
            return k == 0 ? 0 : Integer.MIN_VALUE / 2;
        if (dp[i][k] != null)
            return dp[i][k];

        // Skip picking coins
        int maxi = maxSum(i - 1, k, piles);
        int sum = 0;
        // Pick coins
        if (k > 0) {
            // For current pile, we loop over a prefix sum of coins we can pick. Constraint of both k and length of pile should be applied
            for (int p = 0; p < Math.min(k, piles.get(i).size()); p++) {
                sum += piles.get(i).get(p);
                maxi = Math.max(maxi, sum + maxSum(i - 1, k - p - 1, piles));
            }
        }
        return dp[i][k] = maxi;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new Integer[piles.size()][k + 1];
        return maxSum(piles.size() - 1, k, piles);
    }
}
