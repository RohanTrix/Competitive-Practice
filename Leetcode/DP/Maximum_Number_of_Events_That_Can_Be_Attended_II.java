/**
 *          IDEA : The problem clearly requires DP becuase we need to choose a subset of non-overllaping intervals
 *                 which yield max profit. Moreover we need binary search to find the the last event that occurs on a day
 *                 before our starting day. 
 * 
 * 
 *                  DP STATE : dp[i][k] = Max profit by considering first i intervals with k left to choose
 */

public class Maximum_Number_of_Events_That_Can_Be_Attended_II {
    Integer dp[][];
    int events[][];
    public int maxProf(int i, int k)
    {
        if(k==0) return 0;
        if(i < 0) return 0;
        if(dp[i][k]!=null) return dp[i][k];
        
        // Take
        int currStartTime = events[i][0];
        int l = 0, r = i-1;
        int validInd = -1;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(events[mid][1]>=currStartTime)
                r = mid - 1;
            else
            {
                validInd = mid;
                l = mid + 1;
            }
        }
        int ch1 = events[i][2] + maxProf(validInd, k-1);
        
        // Not take
        int ch2 = maxProf(i-1, k);
        
        return dp[i][k] = Math.max(ch1, ch2);
    }
    public int maxValue(int[][] events, int k) {
        this.events = events;
        Arrays.sort(events, Comparator.comparingInt(arr -> arr[1]));

        int n = events.length;
        dp = new Integer[n][k+1];
        return maxProf(n-1, k);
    }
}
