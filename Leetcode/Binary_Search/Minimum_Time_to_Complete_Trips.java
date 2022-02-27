/*
    IDEA : Here, it will be tough if we directly apply some greedy logic
           to find the minimum time. 
           But here is what needs to be observed. The time taken to complete
           AT LEAST some n number of trips ranges from some MINIMUM time to
           INFINITE TIME. 
           What I mean is, if the MIN time taken to complete AT LEAST n trips is 
           X...then we can also complete it in X+1, X+2...(inf) time period.

           HENCE, this calls for a binary search on time.
           
           Greedy check function of binary search :
           
                Now, for each bus, we will take as many trips as we can which complete
                within the chosen time. In the end, we only check if the number of trips
                is more or equal to the required number of trips.
*/
public class Minimum_Time_to_Complete_Trips {
    public boolean possible(long mid, int time[], int tot)
    {
        long cnt = 0;
        for(int i = 0; i<time.length; i++)
        {
            cnt+=(mid/(1L*time[i]));
        }
        //System.out.println(cnt+" \n");
        return cnt>=tot;
    }
    public long minimumTime(int[] time, int totalTrips) {
        
        long left = 0, right = (long)(1e14);
        //for(int i = 0; i<time.length/2 ; i++) time[i] = time[time.length-i-1];
        long bestAns = 0;
        while(left<=right)
        {
            long mid = left + (right - left)/2;
            if(possible(mid, time, totalTrips))
            {
                bestAns = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return bestAns;
    }
}
