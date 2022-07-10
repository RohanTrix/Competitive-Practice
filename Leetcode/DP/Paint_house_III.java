public class Paint_house_III {
    // DP STATE : dp[i][prev][target] = Min cost of coloring houses[0...i] with
    // i+1th house colored as `prev` and target neighbourhoods left to make
    int[] houses;
    int[][] costArr;
    int n;
    Integer dp[][][];
    int INTMAX = Integer.MAX_VALUE / 2;

    public int minCost(int i, int prev, int target) {
        if (i == -1)
            return target == 0 ? 0 : INTMAX;
        if (target < 0)
            return INTMAX;
        if (dp[i][prev][target] != null)
            return dp[i][prev][target];

        int mini = INTMAX, cost = 0;
        if (houses[i] == 0) {
            // Try to place every color
            for (int col = 1; col <= n; col++) {
                cost = costArr[i][col - 1] + minCost(i - 1, col, target - ((prev == col) ? 0 : 1));
                mini = Math.min(mini, cost);
            }
        } else
            mini = minCost(i - 1, houses[i], target - ((prev == houses[i]) ? 0 : 1));

        return dp[i][prev][target] = mini;
    }

    public int minCost(int[] houses, int[][] costArr, int m, int n, int target) {
        this.houses = houses;
        this.costArr = costArr;
        this.n = n;
        dp = new Integer[m][n + 1][target + 1];
        int mini = INTMAX;

        // Sending color to 0 since it doesn't match to anything
        mini = Math.min(mini, minCost(m - 1, 0, target));
        return mini == INTMAX ? -1 : mini;
    }
}
