/**
 *      IDEA : We start traversing from left to right....for a continuous segment...we want to delete all chars
 *             except the one with the maximum cost. Thus...we keep a running sum and running max of the costs of similar chars...
 *             AS SOON AS the continuous sequence ends...we add (sum - maxCost) to our answer. And we reassign the sum, maxi for the new
 *             sequence starting from this character.   
 * 
 */

public class Minimum_Time_to_Make_Rope_Colorful {
    public int minCost(String colors, int[] cost) {
        char s[] = colors.toCharArray();
        int n = cost.length; 
        int sum = 0, tot = 0, maxi = Integer.MIN_VALUE;
        char prev = s[0];
        for(int i = 0; i<n; i++)
        {
            if(s[i] == prev)
            {
                sum+=cost[i];
                maxi = Math.max(maxi, cost[i]);
            }
            else
            {
                prev = s[i];
                tot+=sum-maxi;
                maxi = cost[i];
                sum = cost[i];
            }
        }
        tot+=sum-maxi;
        return tot;
    }
}
