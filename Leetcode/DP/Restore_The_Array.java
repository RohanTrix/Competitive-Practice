/**
 *      IDEA : Clearly, this is a DP problem because the num of ways to split s[i...n] depends on
 *             s[i+1...n], s[i+2...n] etc
 * 
 *             So we make our DP state as :
 *             DP STATE:
 *              dp[ind] = Num of ways to split such that each num is in [1,k].
 * 
 *             DP TRANSITION:
 *                  At first, if starting from curr ind, we try to partition at every position until n,
 *                  then the T.C of that solution will be O(n^2). However, we can be clever here by using
 *                  the constraints on k. 
 * 
 *                  Since k <=10^9...this tells us that we have only 9 digits at max. So basically, in worst case
 *                  we can stop afterr considering the next 9 letters from curr ind.
 *                  Thus from each DP state, you only make atmost 9 or 10 calls to the the next state.
 *                  Moreover, we will be calcuting the curr_num starting from ind...and as soon as that crosses
 *                  k, we can break since all adding more digits to this will only increase the value of curr_num
 */

public class Restore_The_Array {
    Long dp[];
    long mod = (int)1e9+7;
    public long ways(int ind, char s[], int k)
    {
        if(ind == s.length) return 1; // If we land at end of string, we successfully partitioned the string
        if(s[ind] == '0') return dp[ind] = 0L; // If we land at a 0 as startng pos, then return 0 as leading zero not allowed
        if(dp[ind]!=null) return dp[ind];
        long cnt = 0;
        long curr_num = 0; // running num that is being formed
        for(int i =ind;i<s.length; i++)
        {
            curr_num = curr_num*10 + (s[i] - '0');
            if(curr_num>k) break; // helps prevent an O(n2) soln since k can have max 9 or 10 digits
            cnt+=ways(i+1, s,k);
            cnt%=mod;
        }
        return dp[ind] = cnt;
    }
    public int numberOfArrays(String s, int k) {
        dp = new Long[s.length()];
        return (int) ways(0,s.toCharArray(), k);
    }
}
