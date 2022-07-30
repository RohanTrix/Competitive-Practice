package Leetcode.DP;
/**
 *      IDEA : dp[loc][fuel] = Count of paths which end at `finish` 
 * 
 *             DP TRANS : To go to every location...if fuel allows...add 1 to current path if current location
 *                        is `finish`
 */
public class Count_All_Possible_Routes {
    Long dp[][];
    int locs[], st, fin, mod = (int)1e9+7;
    public long count(int loc, int fuel)
    {
        if(fuel<0) return 0;
        if(dp[loc][fuel]!=null) return dp[loc][fuel];
        long ans = 0;
        if(loc == fin) ans++;
        
        for(int to = 0; to<locs.length; to++)
            if(to != loc)
            {
                ans+=count(to, fuel - Math.abs(locs[loc] - locs[to]));
                ans%=mod;
            }
        return dp[loc][fuel] = ans;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        locs = locations; st = start; fin = finish;
        dp = new Long[locs.length][fuel+1];
        return (int)count(st,fuel);
    }
}
