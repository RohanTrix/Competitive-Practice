/**
 *      IDEA : Problem can be easily rephrased that we want to MINIMIZE the sum of the MAX of each partition
 *             where we have exactly d partitions
 * 
 *             DP[i][d] = Min sum of max of each partition of array arr[0....i] with d days left
 * 
 * 
 */

public class Minimum_Difficulty_of_a_Job_Schedule {
    Integer dp[][];
    int nums[];
    int INTMAX = Integer.MAX_VALUE/2;
    public int minDiff(int i, int d) {
        if(i == -1)
            return d == 0?0:INTMAX;
        if(d == 0) return INTMAX;

        if(dp[i][d]!=null) return dp[i][d];
        dp[i][d] = INTMAX;
        int maxi = -INTMAX;
        for(int p = i; p>=0; p--) {
            maxi = Math.max(maxi, nums[p]);
            dp[i][d] = Math.min(dp[i][d], maxi + minDiff(p-1, d-1));
        }
        return dp[i][d];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.nums = jobDifficulty;
        int n = nums.length;
        dp = new Integer[n][d+1];
        return minDiff(n-1, d)==INTMAX?-1:minDiff(n-1, d);
    }
}
