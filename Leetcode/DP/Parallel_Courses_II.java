/*
 *      IDEA : The problem cannot be solved using Topo Sort/ BFS from indeg=0 kinda approach. This is a little tricky to catch.
 *             but there are test cases that will fail on that.
 * 
 *             Looking at the constraints is a clear hint for Bitmask DP. We want to find the min amt of sems
 *             to complete all courses (FULL MASK).
 *             
 *             DP STATE : dp[mask] = Min no. of sem to complete courses dentoed by set bits in mask
 * 
 *             Algo:
 *                  1) First we built a prereq array that maps i -> mask of set bits of courses which are immediate prereq of i
 *                  2) We iterate on all masks. 
 *                     First, we will build a mask `canTake` that denotes courses that can be taken in 1 sem. There are 2 checks for this
 *                             - Course should not already be completed.
 *                             - All the prereq of the course should already be completed. This is done by ANDing mask with preqreq[i] and checking if equal to prereq.
 *                               since if any bit NOT SET in the mask but SET in prereq[i]...it will result in 0 when ANDing....and so this AND value will never equal
 *                               to prereq of i.
 *                  
 *                  3) Now we use the technique of Submask Enumeration( https://cp-algorithms.com/algebra/all-submasks.html ). This will give us
 *                     all the subsets of canTake. Out of all the subsets of canTake...we only consider the subsets where the courses taken are <=k.
 *                     This is simply done by counting the bits in the submask. `take` denotes the current subset of doable courses we take in 1 sem together.
 *                     
 *                  4) Already taken courses (`mask`) + New taken courses(`take`) can be acheived by (mask | take).
 *                     The ans for dp[mask | take] will be MIN(1 + dp[mask])
 *                     
 */

public class Parallel_Courses_II
{
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] prereq = new int[n];
        for (int[] r : relations) {
            int prev = r[0] - 1;
            int next = r[1] - 1;
            prereq[next] |= (1 << prev);
        }
        
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        
        // Bottom Up DP
        for (int mask = 0; mask < dp.length; mask++) {
            int canTake = 0; // Mask with new courses's that can be taken are set
            for (int i = 0; i < n; i++) {
                // If already taken, continue;
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                // If all prereq satisfied, we CAN TAKE this course
                if ((mask & prereq[i]) == prereq[i]) {
                    canTake |= (1 << i);
                }
            }
            
            // Enumerate over all sub masks
            for (int take = canTake; take > 0; take = (take - 1) & canTake) {
                if (Integer.bitCount(take) > k) { // Cannot take more than k courses at a time
                    continue;
                }
                // New mask with new courses taken in one sem = (take | mask)
                dp[take | mask] = Math.min(dp[take | mask], dp[mask] + 1);
            }
        }
        
        return dp[(1 << n) - 1];
    }
}