package Leetcode.StringHashing;

import java.math.BigInteger;

/**
 *      IDEA : We want to acheive a time complexity of O(n^2).
 * 
 *             Firstly, a+a will have an EVEN length. So we will loop on all even lengths.
 *             Now, for each even length substring, we want to check if the two halfs of it are the same string
 *             or not ( i.e they satisfy AA property or not). To checking whether 2 strings are equal in
 *             constant time, we should use String Hashing precomputation. If they are equal, then we add
 *             the hash to the set (better than adding substring to set as that will take another O(n)).
 * 
 *             Finally, the answer will be the size of the set which is the distinct no. of substrings.
 */


public class Distinct_Echo_Substrings {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Hashing ob = new Hashing(text);
        Set<Long> set = new HashSet<>();
        for (int len = 2; len <= n; len += 2)
            for (int i = 0; i < n - len + 1; i++)

                if (ob.getHash(i, len / 2) == ob.getHash(i + len / 2, len / 2))
                    set.add(ob.getHash(i,len)); // Saving Hash instead of substring to avoid extra O(len) operation

        return set.size();

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
