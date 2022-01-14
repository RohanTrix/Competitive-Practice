class Stone_Game_VIII_dirty_code {
    public int INTMIN = Integer.MIN_VALUE/2;
    public int INTMAX = Integer.MAX_VALUE/2;
    int dp[][];
    public int getScore(int ind, int p, int toAdd, int stones[])
    {
        if(ind==stones.length-1) return p==0?toAdd+stones[ind]: -(toAdd+stones[ind]);
        if(dp[ind][p]!=INTMIN) return dp[ind][p];
        
        if(p==0)
        {
            int bestAns = INTMIN;
            int pref = toAdd;
            pref+=stones[ind];
            int a = pref + getScore(ind+1, 1^p, pref, stones);
            int b = getScore(ind+1, p, pref, stones);
            bestAns = Math.max(a, b);

            return dp[ind][p] = bestAns;
        }
        else
        {
            int bestAns = INTMAX;
            int pref = toAdd;
            pref+=stones[ind];
            int a = -pref + getScore(ind+1, 1^p, pref, stones);
            int b = getScore(ind+1,p,pref, stones);
            bestAns = Math.min(a, b);
            
            return dp[ind][p] = bestAns;
        }
    }
    public int stoneGameVIII(int[] stones) {
        // send from 1 to n
        dp = new int[stones.length][2];
        for(int a[]: dp) Arrays.fill(a, INTMIN);
        
        return getScore(1,0, stones[0], stones);
    }
}

/*
        IDEA:
            The problem is clearly a DP problem. However, one might TLE if the DP is made naively.
            Since for every DP call, if we traverse to end of the array and take max/min of 
            all possible i values in [ind...n], then TC = O(n^2)
            
            Instead, The problem can be modelled a Subset Choosing problem.

            WHY USE PREFIX SUMS:
                E.g : For the first move, if takes stone 0 and 1, the stone array will become
                        [stone[0] + stone[1], stone[2], ... stone[i]]
                    
                      Later if the other player takes the first 3 stones,
                      the score he'll get will be (stone[0] + stone[1]) + stone[2] + stone[3]
            
            DP STATE:
                
                dp[ind][p] = Difference of Score when its player p's turn with array arr[ind-1..n]
            
            DP TRANSITION:

                dp[ind][0] = MAX(
                                    pref[ind] + getScore(ind + 1, 1),
                                    getScore(ind + 1, 0);
                                )
                
                dp[ind][1] = MIN(
                                    -pref[ind] + getScore(ind + 1, 1^p),
                                    getScore(ind + 1, 1)
                                )            

*/

public class Stone_Game_VIII {
    public int INTMIN = Integer.MIN_VALUE/2;
    public int INTMAX = Integer.MAX_VALUE/2;
    int dp[][], pref[];
    public int getScore(int ind, int p)
    {
        
        if(ind==pref.length-1) return (p==0) ? pref[ind]:-pref[ind];
        if(dp[ind][p]!=INTMIN) return dp[ind][p];
        int bestAns;
        
        if(p==0)
        {
            int a = pref[ind] + getScore(ind + 1, 1^p);
            int b = getScore(ind + 1, p);
            bestAns = Math.max(a, b);
        }
        else
        {
            int a = -pref[ind] + getScore(ind + 1, 1^p);
            int b = getScore(ind + 1, p);
            bestAns = Math.min(a, b);
        }
        return dp[ind][p] = bestAns;
    }
    public int stoneGameVIII(int[] stones) {
        // send from 1 to n
        
        pref = new int[stones.length+1];
        for(int i = 1; i<pref.length; i++) pref[i] = pref[i - 1] + stones[i-1];
        
        dp = new int[pref.length][2];
        for(int a[]: dp) Arrays.fill(a, INTMIN);
            
        return getScore(2,0);
    }
}