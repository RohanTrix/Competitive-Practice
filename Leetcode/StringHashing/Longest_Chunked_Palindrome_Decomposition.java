package Leetcode.StringHashing;
import java.math.BigInteger;

/**
 *      IDEA : CAUTION --> STRING HASHING INVOLVED.....CRAZY TEMPLATE USED, NOT FOR INTERVIEWS
 *              
 *             The idea is a bit greedy...we take the same length prefix and suffix....we try to 
 *             check if they make the same word (this is acheived in O(1) by String Hashing).
 *             If it is, we chop it off the 2 words...and find answer for remaining string.
 * 
 */


public class Longest_Chunked_Palindrome_Decomposition {
    Hashing ob;
    char s[];

    public int countDecomp(int l, int r) {

        if (l > r)
            return 0;
        int pl = l, pr = r; // The pointers indicate the following in the string :  l --- pl xxxxx pr ---- r
        while (pl <= pr) {
            if (ob.getHash(l, pl - l + 1) == ob.getHash(pr, r - pr + 1))
                break;
            pl++;
            pr--;
        }
        if (pl >= pr)
            return 1;
        return 2 + countDecomp(pl + 1, pr - 1);
    }

    public int longestDecomposition(String text) {
        ob = new Hashing(text);
        s = text.toCharArray();
        int n = s.length;
        return countDecomp(0, n - 1);
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
