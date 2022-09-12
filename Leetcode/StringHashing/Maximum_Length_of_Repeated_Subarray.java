package Leetcode.StringHashing;
import java.math.BigInteger;

/**
 *     IDEA : DP is somehow too slow for this ( I cannot understand why)
 *            Next, I notices that...let's say we know a subarray appears in both arrays.
 *            Then we know that smaller subarrays of this subarray are also repeating(but will not be our
 *            answer cuz we need max size)....this gives a binary searchable property on the length
 *            of the subarray.
 * 
 *            So now lets say we pick a length for the subarray, we want to check if any such subarray
 *            is present both in first and second. We can use Hashing(after converting array to string
 *            so that I was able to use the Hashing class I made earlier)
 *            and check in O(1) time. So we will traverse all chosen length substrings/subarrays of the first array
 *            and add them to a SET. Next while traversing the chosen length subarray of the second array,
 *            if we find any subarray already in the SET, then we know that subarray exists.
 */

public class Maximum_Length_of_Repeated_Subarray {
    Hashing ob1, ob2;
    int n1, n2;
    public boolean exists(int len)
    {
        Set<Long> set = new HashSet<>();
        for(int i = 0;i<n1-len+1; i++)
            set.add(ob1.getHash(i,len));
        
        for(int i = 0;i<n2-len+1; i++)
            if(set.contains(ob2.getHash(i,len)))
                return true;
        return false;
    }
    public int findLength(int[] nums1, int[] nums2) {
        n1 = nums1.length; n2 = nums2.length;
        //Converting Array to Strings
        StringBuilder str = new StringBuilder();
        for(int num : nums1)
            str.append((char)num);
        
        ob1 = new Hashing(str.toString());
        str = new StringBuilder();
        for(int num : nums2)
            str.append((char)num);
        
        ob2 = new Hashing(str.toString());
        
        int l = 1, r = Math.min(nums1.length, nums2.length);
        int ans = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(exists(mid))
            {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
    
    
    class Hashing {
    
        static final int multiplier = 101; // Value should be a PRIME AND > character set size
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
