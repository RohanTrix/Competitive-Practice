/*     IDEA: We can simply check if at any position the total number of people
             travelling exceeds capacity. If it doesnt happen, ans is true.

             Since we have a lot of ranges, we could have used a greedy approach. But here we can use
             partial sums to create a prefix sum structure. There's a small detail we should note:
                
                * Normally in partial sums update query (l,r), we add at l position and subtract at r+1 position. 
                  But in a case where
                  capacity = 5 and there is a pickup of 2 and dropoff of 4, we will get `false` as
                  our answer instead of true, as we can first dropoff 4 guys and then pickup at same location,
                  hence never exceeding the capacity.
                
                  So, if we use (l, r) for update , we get WA. Instead we can use (l, r-1) for update,
                  as on rth day we first want to dropoff(the first thing to do when reached) and then pickup.

            Finally, we take prefix sum, and for every i, we check if the number of people on bus exceed capacity.
*/
public class Car_Pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int pref[] = new int[1002];
        for (int i = 0; i < trips.length; i++) {
            pref[trips[i][1]] += trips[i][0];
            pref[trips[i][2]] -= trips[i][0];
        }
        if (pref[0] > capacity)
            return false;
        for (int i = 1; i < 1002; i++) {
            pref[i] += pref[i - 1];
            if (pref[i] > capacity) {
                return false;
            }
        }
        return true;

    }
}
