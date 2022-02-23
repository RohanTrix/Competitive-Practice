/*
    IDEA : In the HashMap, storing the numbers might not be enough for such a ounting problem.
            Since, for example, k = 10....a product of 2,5 as well as 4,5 as well as 6,5 is divisible
            by k and counting each of these might become n2 in the worst case even on using a hashmap.
            
            Instead a good observation would be that it is enough to store the GCDs of each no. with k.
            This is because, the GCD will be one of the divisors of k, and we know that k has divisors
            upto sqrt(k). So finally, we can just traverse all previous GCDs in the map and check if
            the curr_no's gcd multiplied with prev gcd is divisble by k or not. Since only sqrt(k) gcds
            are possible at max, time complexity is N* sqrt(k) 
*/
public class Count_Array_Pairs_Divisible_by_K {
    public long gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public long countPairs(int[] nums, int k) {
        HashMap<Long, Long> map = new HashMap<>();
        long cnt = 0;
        for(int i : nums)
        {
            long gcd_curr = gcd(i,k);
            for(long prev_gcd : map.keySet())
            {
                if((gcd_curr*prev_gcd)%k==0)
                    cnt+=map.get(prev_gcd);
            }
            map.put(gcd_curr, map.getOrDefault(gcd_curr, 0L)+1L);
        }
        return cnt;
    }
}
