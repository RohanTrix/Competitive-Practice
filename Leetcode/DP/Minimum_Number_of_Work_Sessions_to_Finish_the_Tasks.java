/**
 * IDEA : Greedy does not work for this problem because, after sorting, we can add a larger task with 2-3 smaller taks(which are non continuous
 *        in their sorted form). This kind of logic cannot be implemented by greedy.
 *        
 *        Moreover, the constraints hint towards  Bitmask DP. 
 *        
 *        DP STATE : dp[mask][timeLeft] = Minimum number of sessions to complete tasks whcih are unmarked in `mask` with current
 *                                        session's remaining time as `timeLeft`.
 *        
 * 
 *        DP TRANSITION : From every state, we loop over the tasks and try to add ith unmarked task to the current session OR
 *                        create a new session. For all such tasks that we can add, we take a minimum of the cnt of sessions across
 *                        all of them
 */

public class Minimum_Number_of_Work_Sessions_to_Finish_the_Tasks {
    Integer dp[][];
    int sess;
    public int minTime(int mask, int timeLeft, int tasks[])
    {
        if(mask == (1<<tasks.length)-1)
            return 0;
        if(dp[mask][timeLeft] !=null) return dp[mask][timeLeft];
        
        int cnt = Integer.MAX_VALUE;
        for(int i = 0; i<tasks.length; i++)
        {
            if((mask&(1<<i))!=0) continue;
            
            int newMask = mask|(1<<i);
            if(timeLeft<tasks[i])
                cnt = Math.min(cnt, 1+minTime(newMask,sess-tasks[i], tasks));
            else
                cnt = Math.min(cnt, minTime(newMask, timeLeft-tasks[i], tasks));
        }
        return dp[mask][timeLeft] = cnt;
    }
    public int minSessions(int[] tasks, int sessionTime) {
        sess = sessionTime;
        dp = new Integer[1<<tasks.length][sess+1];
        return 1+minTime(0,sess, tasks);
    }
}
