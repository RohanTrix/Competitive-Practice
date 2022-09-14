/**
 *      IDEA : This question is a bit tricky since normally we would think of bitmasking
 *             on the hats. But doing that will be 2^40 which is def not gonna pass
 * 
 *             HINT : Based on the constraints, try to bitmask the number of people...that is
 *                    which people are assigned hats or not.
 * 
 *             Now, the idea is...go on each hat...we will either skip this hat or try to assign it.
 *             Skipping is easy just send a call to the next hat
 * 
 *             Now, if we want to assign this hat, we have to see who all can wear this hat.
 *             We traverse on all persons, consider the ones who have not assined a hat yet.
 *             Then...if a person has a preference for the currHat, get the count of ways by assinging him
 *             the current hat. Accumulate all such counts.
 * 
 */

public class Number_of_Ways_to_Wear_Different_Hats_to_Each_Other {
    Long dp[][];
    int n;
    int mod = (int)1e9 + 7;
    public long count(int currHat, int mask, List<List<Integer>> hats)
    {
        if(mask == (1<<n) - 1) return 1; // All have been assigned the mask
        if(currHat == 41) return 0; // Masks over but not all assined
        if(dp[currHat][mask]!=null) return dp[currHat][mask];
        
        // Iterate on which person can attain this hat
        
        long cnt = count(currHat+1, mask, hats); // Skip assigning current hat
        for(int i = 0; i<n; i++) // Iterate on all persons
        {
            if((mask & (1<<i))==0) // If person has not been assigned a hat yet
            {
                for(int wearableHat : hats.get(i)) // Traverse all preferred hats of this person
                    if(wearableHat == currHat) // If he prefers current hat, assign him and get ways
                    {
                        cnt+=count(currHat+1, mask | (1<<i), hats);
                        cnt%=mod;
                    }
            }
        }
        return dp[currHat][mask] = cnt;
        
    }
    public int numberWays(List<List<Integer>> hats) {
        
        n = hats.size();
        dp = new Long[41][1<<n];
        return (int)count(1, 0, hats);
    }
}
