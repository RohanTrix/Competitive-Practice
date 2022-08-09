/**
 * 
 *      IDEA : Taking one look at the constraints will make it clear that bitmasking is the
 *             way to go. So I make a mask of the requests. So the idea is to choose a subset
 *             and then check whether the net change for all buildings after satisfying the chosen requests
 *             is ZERO or not. If for any building it is not zero, we discard it. Now, we just want max
 *             size of the subset. 
 *             So the number of requests is simply the bit count in the number. We take the max of 
 *             all valid masks.
 */
public class Maximum_Number_of_Achievable_Transfer_Requests {
    public int maximumRequests(int n, int[][] requests) {
        int count[] = new int[n];
        int len = requests.length;
        int maxi = 0;
        outer:
        for(int mask = 0;mask<(1<<len); mask++)
        {
            Arrays.fill(count, 0);
            for(int j = 0;j<len; j++)
            {
                if((mask&(1<<j))!=0)
                {
                    int req[] = requests[j];
                    count[req[0]]--;
                    count[req[1]]++;
                }
            }
            for(int num : count) if(num !=0) continue outer;
            maxi = Math.max(maxi,Integer.bitCount(mask));
        }
        return maxi;
    }
}
