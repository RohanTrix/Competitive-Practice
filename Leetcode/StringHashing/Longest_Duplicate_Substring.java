import java.math.BigInteger;

// IDEA : Lets say we know a substring like "aba" repeats twice in "ababa"...if this is true, then
//        we can be certain that substrings of this "aba" also repeat themselves...like "a" or "ab"
//        Thus, we can binary search on the length of the string.
//        Now say we pick a length k....we want to perform a fixed sliding window and check if strings
//        strings any k length similar string has occured before....we can use a HasSet for checking if
//        there occurence is more than once......But searching whether current string is present in set
//        or not is still an O(len) operation....We can use String Hashing precomputation to later acheive this
//        in O(1)

public class Longest_Duplicate_Substring {
    Hashing ob;
    String ans = "";
    public boolean rollingHash(String str, int len)
    {
        Set<Long> hs = new HashSet<>();
        int n = str.length();
        long currHash = 0;
        for(int i = 0; i<n-len+1; i++)
        {
            currHash = ob.getHash(i,len);
           
            if(hs.contains(currHash))
            {
                ans = str.substring(i,i+len);
                return true;
            }
            hs.add(currHash);
        }
        return false;
    }
    public String longestDupSubstring(String str) {
        char s[] = str.toCharArray();
        int n = s.length;
        ob = new Hashing(str);
        int left = 1, right = n;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(rollingHash(str, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return ans;
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
