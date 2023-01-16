package Leetcode.Binary_Search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *      IDEA : We need to know the lastOccurence position of a lake's rain day since we want to
 *             only allocate drain days after this day. Moreover, we need to assign drain days such that
 *             out of the available drain days(some drain days may be removed/assigned to lakes coming before curr_lake)
 *             we get the earliest one.
 * 
 *             FOllow comments to get better idea
 */

public class Avoid_Flood_in_The_City
{
    public int[] avoidFlood(int[] rains) {
        
        // Contains active idxs of days where we can drain a lake
        TreeSet<Integer> drainDays = new TreeSet<>();

        int n = rains.length;
        // Stores lake -> las idx when it rained
        Map<Integer, Integer> lastOccurence = new HashMap<>();
        
        int ans[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            int lake = rains[i];
            if(lake>0) // Rain Day
            {
                ans[i] = -1;
                if(lastOccurence.containsKey(lake)) // If it has previously rained, we need a drying day in between.
                {
                    // Out of the active idxs of drying days, we find the first one occuring after the
                    // last occurence of the curr lake.
                    Integer drain = drainDays.higher(lastOccurence.get(lake));
                    // If drain == null, means no drying day available and hence flood is unavoidable.
                    if(drain == null) return new int[]{};
                    ans[drain] = lake; // Save ans for `drain` drying day as drying lake `lake`
                    drainDays.remove(drain); // Since we used `drain`, we should remove it from active idxs
                }
                lastOccurence.put(lake, i); // Updat elast occurence of rain
            }
            else
                drainDays.add(i); // Add to active idx.
        }
        for(Integer drain : drainDays) ans[drain] = 1; // For unused drying days...we just fill it with 1.
        return ans;
    }
}