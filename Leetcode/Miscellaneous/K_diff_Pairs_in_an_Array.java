/* 
    IDEA : We use a running HashMap. As soon as an element comes,
           we want to pair it up with ONE num+k value and ONE num-k value....but if it was already present
           in the hashmap, then whether num+k (or num-k) would have occured before num's occurence or 
           after num's occurence, the pair would already have been formed during this loop.
           So we only form a pair when the element that has just come does not exist in the map before.

           Also, we need unique pairs so we kind of do not require the value of the map.

           Finally a base case can be, k = 0. Since we are not adding if val was already present in the 
           hashmap, pairs like (1,1) or (2,2) will be left out. So for k = 0, we just count keys with
           value more than 1. Each of them will form exactly one pair
*/

public class K_diff_Pairs_in_an_Array
{
    public int findPairs(int[] nums, int k) {
        HashMap<Long, Long> hm = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i<nums.length; i++)
        {
            long num = (long)nums[i];
            if(hm.keySet().contains(num) == false)
            {
                if(hm.keySet().contains(num+k))
                    cnt+=1;
                if(hm.keySet().contains(num-k))
                    cnt+=1;
            }
            hm.put(num, hm.getOrDefault(num,0L)+1L);
        }
        if(k == 0)
        {
            for(long key : hm.keySet())
                cnt+=(hm.get(key)>1)?1:0;
        }
        return (int)cnt;
    }
}