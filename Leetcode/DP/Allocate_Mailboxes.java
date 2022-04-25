public class Allocate_Mailboxes
{   // REFER : IDEA from https://youtu.be/s4GyrzuXUZA
    Integer dp[][];
    int cost[][];
    int n;
    public int minCost(int ind, int k)
    {
        if(k == 0) return ind!=n?Integer.MAX_VALUE/2:0;
        if(ind == n) return Integer.MAX_VALUE/2;
        if(dp[ind][k]!=null) return dp[ind][k];
        int mini = Integer.MAX_VALUE/2;
        
        for(int i = ind; i<n; i++)
        {
            mini = Math.min(mini, cost[ind][i] + minCost(i+1, k-1));
        }
        // System.out.println(mini);
        return dp[ind][k] = mini;
    }
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        cost = new int[n][n];
        dp = new Integer[n][k+1];
        calculateMedianCosts(houses);
        
        int ans = minCost(0,k);
        // for(int a[]: cost)
        //     System.out.println(Arrays.toString(a));
        return ans;
    }
    public void calculateMedianCosts(int houses[])
    {
        
        int pref[] = new int[n+1];
        for(int i = 1; i<=n; i++)
            pref[i] = pref[i-1]+houses[i-1];

        for(int gap = 0; gap<n; gap++)
        {
            for(int i = 0, j = gap; j<n; i++,j++)
            {
                if(gap == 0)
                    cost[i][j] = 0;
                else if(gap == 1)
                    cost[i][j] = houses[j] - houses[i];
                else
                {
                    int pi = i+1, pj = j+1;
                    int pmid = (pi+pj)/2;
                    int mid = (i+j)/2;
                    int leftSum = pref[pmid-1] - pref[pi-1];
                    int rightSum = pref[pj] - pref[pmid];

                    cost[i][j] = ((mid-i)*houses[mid] - leftSum) + (rightSum - (j-mid)*houses[mid]);
                }
            }
        }
    }
}