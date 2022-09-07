/*
 *      IDEA : Firstly, the binary searchable property here is that if we are able to find some
 *             k consecutive robots which satisfy the conditions...then we know it holds true for k-1 consecutive
 *             or k-2 consecutive as well (since they are just subarrays of k consecutive)
 * 
 *             
 *             Now, after we fix k, we need to handle the following equation
 *             
 *                          max(chargeTimes) + k * sum(runningCosts)
 * 
 *            1) sum(runningCosts) for some k consecutive elements can be easily found using prefix sums/running sum
 *            2) max(chargeTimes) for some k consecutive elements is a FAMOUS SUBPROBLEM of `SLIDING WINDOW MAXIMUM`
 * 
 *            Revisit these subproblems if one needs to understand the code
 * 
 */
public class Maximum_Number_of_Robots_Within_Budget {
    int charge[], run[];
    int n;
    public boolean possible(int k, long budget)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        long currSum = 0;
        for(int i = 0; i<n; i++)
        {
            if(i>=k)
            {
                currSum-=run[i-k];
                if(dq.peekFirst() == charge[i-k])
                    dq.pollFirst();
            }
            currSum+=run[i];
            while(!dq.isEmpty() && dq.peekLast() < charge[i])
                dq.pollLast();
            dq.offerLast(charge[i]);
            if(i>=k-1 && (1L*dq.peekFirst() + 1L*k*currSum) <= budget)
                return true;
        }
        return false;
    }
    
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        this.charge = chargeTimes;
        this.run = runningCosts;
        n = run.length;
        int l = 1, r = n;
        int ans = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(possible(mid, budget))
            {
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
}
