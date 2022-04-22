/*
    IDEA : Since we need to find the path with least no. of sidejumps, we can go for DP.
           The intuition for DP is that once we have calculated minCost to reach from i -> n,
           then we can find out the answer for i-1 -> n as well.

           DP STATE: dp[i][lane] = Min cost to reach n from i and currently standing on lane `lane`

           DP Transition :
                We add 1 if we are going sideways, but we only jump sideways if the obstacles[i] != lane we jump on.
                So basically, we add 1 for the jump, and call minJumps for i+1 and new changed lane

                Or we decide to go straight without adding a jump.

                If we arrive at a cell with a rock, we return INT_MAX to not consider that path.

*/
public class Minimum_Sideway_Jumps
{
    Integer dp[][];
    int n;
    int obstacles[];
    public int minJumps(int i, int lane)
    {
        if(i == n) return 0;
        if(obstacles[i] == lane) return Integer.MAX_VALUE/2;
        if(dp[i][lane]!=null) return dp[i][lane];
        dp[i][lane] = Integer.MAX_VALUE/2;
        
        for(int p = 1; p<=3; p++)
        {
            if(obstacles[i] == p) continue; // If we cannot jump to this lane, we skip
            if(p == lane) dp[i][lane] = Math.min(dp[i][lane], minJumps(i+1,lane)); // Move frwrd in same lane
            else dp[i][lane] = Math.min(dp[i][lane], 1 + minJumps(i+1,p)); // Jump and move to next i
        }
        return dp[i][lane];
    }
    public int minSideJumps(int[] obstacles) {
        this.obstacles = obstacles;
        n = obstacles.length;
        dp = new Integer[n+1][4];
        return minJumps(0, 2);
    }
}