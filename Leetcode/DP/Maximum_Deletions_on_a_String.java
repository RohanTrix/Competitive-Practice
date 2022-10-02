import java.math.BigInteger;
/*
 *      IDEA : First it easy to solve the problem of checking whether 2 substrings are EQUAL OR NOT in O(1) after O(N)
 *             preprocessing using String Hashing. Now, we have to use a partition logic (Similar logic used : https://leetcode.com/problems/palindrome-partitioning-ii/)
 * 
 *             So we can define our DP as DP[i] = Maximum number of operations to delete the string
 *             DP Transition : If s[i..i+len-1] == s[p+1...p+len]....then take MAX with 1 + DP[p+1]
 * 
 */



public class Maximum_Deletions_on_a_String {
    Hashing ob;
    int n;
    Integer dp[];
    public int maxOps(int i)
    {
        if(i == n) return 0;
        if(dp[i] != null) return dp[i];
        int maxi = 1;
        for(int p = i; p<n; p++)
        {
            int len = p-i+1;
            if(p+len>=n) break;
            if(ob.getHash(i,len) == ob.getHash(p+1, len))
                maxi = Math.max(maxi, 1 + maxOps(i+len));
        }
        return dp[i] = maxi;
    }
    public int deleteString(String s) {
        n = s.length();
        ob = new Hashing(s);
        dp = new Integer[n];
        return maxOps(0);
    }
    
    class Hashing {

        static final int multiplier = 43;
        static final Random rnd = new Random();
        static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int invMultiplier1 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod1))
                .intValue();
        static final int invMultiplier2 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod2))
                .intValue();

        long[] hash1, hash2;
        long[] inv1, inv2;
        int n;

        public Hashing(String s) {
            n = s.length();
            hash1 = new long[n + 1];
            hash2 = new long[n + 1];
            inv1 = new long[n + 1];
            inv2 = new long[n + 1];
            inv1[0] = 1;
            inv2[0] = 1;

            long p1 = 1;
            long p2 = 1;
            for (int i = 0; i < n; i++) {
                hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
                p1 = p1 * multiplier % mod1;
                inv1[i + 1] = inv1[i] * invMultiplier1 % mod1;
                hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
                p2 = p2 * multiplier % mod2;
                inv2[i + 1] = inv2[i] * invMultiplier2 % mod2;
            }
        }

        public long getHash(int i, int len) {
            return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32)
                    + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;
        }
    }
}
