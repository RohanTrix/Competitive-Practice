/*
 *  IDEA : It is not just about choosing the highest GCD for the higher op no....this is because, it might be possible that
 *         if we conisder (a,b) pair for op 5 when there could have been another option (a,c) giving the same higher GCD.
 *         And it may have been more profitable to use the (a,c) pair bcuz maybe b could have formed the next higher GCD
 *         with some other number.
 * 
 * 
 *         Thus, looking at the constraints(2*n<=14), we can think of enumerating all possible paths of choosing pairs.
 *         Moreover, this can be memoized ----> for example consider we have choices (A,B) and (C,D) and after this we have 
 *         a remaining array [E,F,G,H,.....]. Now, there are two paths possible
 *                  
 *                  1) CHOOSE (A,B) for op1 and CHOOSE (C,D) for op2
 *                  2) CHOOSE (C,D) for op1 and CHOOSE (A,B) for op2
 *         
 *         The remaining array, after EITHER of the operations will be the SAME....and hence there is overlap between the paths.
 *         This suggests that we can use a bitmask to store the elements that have been taken
 * 
 */
public class Maximize_Score_After_N_Operations
{
    Integer dp[][];
    int n, mat[][];
    public int maxProfit(int op, int mask)
    {
        if(op == n+1) return 0;
        if(dp[op][mask]!=null) return dp[op][mask];
        
        int maxi = 0;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                if(i!=j && (mask&(1<<i))==0 && (mask&(1<<j))==0)
                {
                    int currScore = op*mat[i][j];
                    int newMask = (mask|(1<<i))|(1<<j);
                    maxi = Math.max(maxi, currScore + maxProfit(op+1, newMask));
                }
        return dp[op][mask] = maxi;
    }
    public int maxScore(int[] nums) {
        n = nums.length;
        
        mat = new int[n][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                mat[i][j] = gcd(nums[i], nums[j]);
        
        dp = new Integer[n+1][1<<n];
        return maxProfit(1,0);
    }
    public int gcd(int a, int b)
    {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
}