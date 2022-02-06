/*
    IDEA : We will use prefix sums for this problem as DP does not work. DP does not work
           because if we find the maximum path for one robot, it does not necessarily mean
           that the second robot's best path has beem minimised.

           Here is the idea to think of think about this solution:
           1) Build prefix sums of 1st row and 2nd row. 
           2) Try to make each point i as the point where robot 1 goes down.
              By doing this, we know it leaves some 
              suffix subarray of the 1st row and a prefix subarray in the second row.
              The 2nd robot can take either of these paths(not both of course), and since it wants
              to maximise its score, it will take max of these 2 subarrays.

              Now since, robot 1 is also playing optimally, he will take minimum of all the best points
              which robot 2 can score at each index. That is our final answer.

*/
public class Grid_Game {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long up[] = new long[n+1];
        long down[] = new long[n+1];
        for(int i = 1; i<=n ;i++)
        {
            up[i] = up[i-1]+grid[0][i-1];
            down[i] = down[i-1]+grid[1][i-1];
        }
    
        long ans = Long.MAX_VALUE;
        for(int i = 1; i<=n; i++)
        {
            long upper = up[n]-up[i];
            long lower = down[i-1];
            //System.out.println(upper+" "+lower);
            ans = Math.min(ans, Math.max(upper, lower));
        }
        return ans;
        
    }
}
