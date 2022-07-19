

// AC Approach

/*
    IDEA : The first idea I had was Bitmask DP where I use a bitmask for the cuts that have been used.
           But that idea would not work since cuts have length upto 100.

           Also, it becomes clear that bitmask is not required as after we have made a cut, the range of
           the stick will also decrease and we will never encounter that cut again. But bitmask is needed
           when we need to remember which cuts we have made.

           The next idea was to use DP[i][j] on the length of stick. But storing that caused MLE as
           length is 10^6.

           One good thing to note is that the cuts array is only of size 100. Also, after sorting 
           the array cuts, we know that after making a cut at cuts[i], the cuts for the left half will
           be chosen from the part before cuts[i] and right half will be chosen from the part after cuts[i].

           Thus, we use DP[i][j] on cuts array. But alongside, we also pass on the left and right bounds
           of the stick(not store it as it is not required). We basically try to cut at each point like
           a DnC dp and take the minimum of every cut that we try.

           So basically,
           DP STATE : 
                      dp[i][j] = Minimum cost to make all cuts in cuts[i...j];

           DP TRANSITION:
                      dp[i][j] = Min cost across all cuts + (rightBound - leftBound)

*/

public class Minimum_Cost_to_Cut_a_Stick
{
    Integer dp[][];
    public int minCostToCut(int left, int right, int leftBound, int rightBound, int cuts[])
    {
        if(left>right) return 0;
        if(dp[left][right] != null) return dp[left][right];
        
        int cost = Integer.MAX_VALUE/2;
        
        for(int i = left; i<=right; i++)
        {
            int leftHalf = minCostToCut(left, i-1, leftBound, cuts[i], cuts);
            int rightHalf = minCostToCut(i+1, right, cuts[i], rightBound, cuts);
            cost = Math.min(cost, leftHalf + rightHalf);
        }
        return dp[left][right] = cost + (rightBound - leftBound);
    }
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        dp = new Integer[cuts.length+1][cuts.length+1];
        int ans = minCostToCut(0, cuts.length-1,0,n, cuts);
        
        return ans;
    }
}

// MLE Approach
public class Minimum_Cost_to_Cut_a_Stick1
{
    Integer dp[][];
    public int minCostToCut(int left, int right, int cuts[])
    {
        if(dp[left][right] != null) return dp[left][right];
        
        int cost = Integer.MAX_VALUE/2;
        for(int cut : cuts)
        {
            if(left<cut && right>cut)
            {
                cost = Math.min(cost, minCostToCut(left, cut, cuts) + minCostToCut(cut, right, cuts));
            }
        }
        if(cost == Integer.MAX_VALUE/2) return dp[left][right] = 0;
        return dp[left][right] = cost + (right - left);
    }
    public int minCost(int n, int[] cuts) {
        
        //Arrays.sort(cuts);
        dp = new Integer[n+1][n+1];
        int ans = minCostToCut(0, n, cuts);
        //for(Integer a[] : dp) System.out.println(Arrays.toString(a));
        return ans;
    }
}