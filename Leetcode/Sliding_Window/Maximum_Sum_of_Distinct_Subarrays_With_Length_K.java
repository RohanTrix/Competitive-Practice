/**
 *      IDEA : Clearly this is a fixed slinding window question with size = k. We need to maintain 2 things about the window.
 *             1) sum of the k elements(of course)....and 2) a freq map of elements....to check whether all elements are unique or
 *             not, we check if the no. of keys in map == k...then every key will only have one occurence.
 * 
 * 
 */
public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K
{
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, maxi = 0;
        int n = nums.length;
        for(int right = 0; right<n; right++)
        {
            sum+=nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            if(right>=k-1)
            {
                if(right>=k)
                {
                    map.put(nums[right - k], map.get(nums[right - k]) - 1);
                    if(map.get(nums[right - k]) == 0)
                        map.remove(nums[right - k]);
                    sum-=nums[right - k];
                }
                if(map.size() == k)
                    maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
        
    }
}