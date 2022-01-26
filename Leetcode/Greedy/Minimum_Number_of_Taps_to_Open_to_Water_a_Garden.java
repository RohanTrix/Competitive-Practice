public class Minimum_Number_of_Taps_to_Open_to_Water_a_Garden
{
/*
        IDEA:
            Instead of taking the ranges upto left and upto right, we can remodel the problem as
            tap i watering from left and going upto right. This is analogous to Jump Game II where
            each cell represents max jump we can take from here.

            One thing to note in this problem is, for case like [0,1,0,0,1,0],
            the answer is -1 since the waters from both the taps DO NOT OVERLAP. 
*/
    public int minTaps(int n, int[] ranges) {
        int jumps[] = new int[n+1];
        
        // Converting problem to Jump Game II type input
        for(int i =0; i<=n; i++)
        {
            int begin =  Math.max(0,i-ranges[i]);
            int jump = i-begin + ranges[i];
            jumps[begin] = Math.max(jumps[begin], jump);
        }
        // Jump Game II logic
        int taps = 0;
        int currEnd = 0, maxPosReachable = 0;
        for(int i =0; i<n; i++)
        {
            maxPosReachable = Math.max(maxPosReachable, i+jumps[i]);
            if(i == currEnd)
            {
                if(maxPosReachable==currEnd)
                {
                    if(jumps[i+1]==0)
                        return -1;
                    else
                        taps++;
                        currEnd = Math.max(currEnd+1, maxPosReachable);
                }
            }
        }
        return taps;
    }
}
class Solution {
    public int minTaps(int n, int[] ranges) {
        int jumps[] = new int[n+1];
        
        for(int i =0; i<=n; i++)
        {
            int begin =  Math.max(0,i-ranges[i]);
            int jump = i-begin + ranges[i];
            jumps[begin] = Math.max(jumps[begin], jump);
        }
        int taps = 0;
        int currEnd = 0, maxPosReachable = 0;
        for(int i =0; i<n; i++)
        {
            maxPosReachable = Math.max(maxPosReachable, i+jumps[i]);
            if(i == currEnd)
            {
                if(maxPosReachable<=currEnd) return -1;
                taps++;
                currEnd = maxPosReachable;
            }
        }
        return taps;
    }
}