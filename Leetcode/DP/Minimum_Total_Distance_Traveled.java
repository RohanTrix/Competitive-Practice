/**
 *      IDEA : DP STATE:
 *                      DP[i][j] = Min Distacnce on assign robots uptil ith to factory uptil jth.
 *             
 *             The logic is that for jth fact, we try to assign i, (i and i-1), (i, i-1, i-2) robots keeping within the capacity of that
 *             factory. And we want to take the minimum across all these assignments. We can also precalc cost[][] which is cost for robot[i] to
 *             reach fact[j].
 *             
 *             2 types of DP TRANSITION :
 *                  1) Skip assigning any robot to current factory
 *                  2) assing a suffix (within capacityof current factory) to current jth factory.
 * 
 * 
 */
public class Minimum_Total_Distance_Traveled {
    List<Integer> robot;
    Long dp[][];
    int fact[][];
    long cost[][];
    long LONGMAX = Long.MAX_VALUE / 2;

    public long minCost(int i, int j) {
        if (i == -1)
            return 0L;
        if (j == -1)
            return LONGMAX;
        if (dp[i][j] != null)
            return dp[i][j];
        long minProf = minCost(i, j - 1);
        long currCost = 0;
        for (int k = 0; k < fact[j][1]; k++) {
            if (i - k < 0)
                break;
            currCost += cost[i - k][j];
            minProf = Math.min(minProf, currCost + minCost(i - k - 1, j - 1));
        }
        return dp[i][j] = minProf;

    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int r = robot.size(), f = factory.length;
        this.robot = robot;
        this.fact = factory;
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        dp = new Long[r + 5][f + 5];
        cost = new long[r][f];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < f; j++)
                cost[i][j] = Math.abs(robot.get(i) - fact[j][0]);
        return minCost(r - 1, f - 1);
    }
}
