/**
 *      IDEA : Problem can be easily rephrased that we want to MINIMIZE the sum of the MAX of each partition
 *             where we have exactly d partitions
 * 
 *             DP[i][k] = Min sum of each partition of array arr[i...n] with k+1 partitions left
 * 
 * 
 */

public class Minimum_Difficulty_of_a_Job_Schedule {
    int jobs[], n;
    Integer dp[][];
    public int minCost(int i, int k)
    {
        if(k == 0) // Last part..so return the max of this part
        {
            int maxi = 0;
            for(int j = i; j<n; j++)
                maxi = Math.max(maxi, jobs[j]);
            return maxi;
        }
        if(i == n)
            return Integer.MAX_VALUE/2;
        if(dp[i][k]!=null) return dp[i][k];
        int mini = Integer.MAX_VALUE/2;
        int currMax = 0;
        for(int p = i; p<n-1; p++) // We try to partition every point except the last cuz at least one element should be present in the last partition
        {
            currMax = Math.max(currMax, jobs[p]); // running max for current partition
            mini = Math.min(mini, currMax+minCost(p+1, k-1));
        }
        return dp[i][k] = mini;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobs = jobDifficulty;
        n = jobs.length;
        if(n<d) return -1;
        dp = new Integer[n][d];
        return minCost(0, d-1); // To make d partitions you have d-1 partitioningLines to place
        
    }
}
