/*
    Quite Easy for a hard :)
    IDEA : Key observation to avoid a MLE is that the max steps are 500. But arrLen is given to go upto 10^6. So the max we can go
           to the end of the array is at the 500th index.
           So to store `pos`, we only need to allot upto 500.

           DP STATE: dp[step][pos] = Having used `step` steps till now and at currently position `pos`,
                                     how many ways are there to end up at 0 index

           DP TRANSITION : Quite simply the moves that are given in the question. Follow code to figure out.
                                     
*/
public class Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps {
    Long dp[][];
    int mod = (int) 1e9+7;
    int MAX_STEPS, LEN;
    public long count(int step, int pos)
    {
        if(pos<0 || pos==LEN) return 0;
        if(step == MAX_STEPS) return pos==0?1:0;
        
        if(dp[step][pos]!=null) return dp[step][pos];
        
        long cnt = 0;
        cnt+=count(step+1, pos+1); cnt%=mod;
        cnt+=count(step+1, pos); cnt%=mod;
        cnt+=count(step+1, pos-1); cnt%=mod;
        return dp[step][pos] = cnt;
    }
    public int numWays(int steps, int arrLen) {
        dp = new Long[500+1][500+1];
        MAX_STEPS = steps; LEN = arrLen;
        return (int) count(0, 0);
    }
}
