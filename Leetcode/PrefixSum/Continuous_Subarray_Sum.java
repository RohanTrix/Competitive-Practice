public class Continuous_Subarray_Sum {
    // Refer notes of LC : Subarray Sums Divisible by k
    // Here instead of storing the count, I am storing the first index of a prefix sum I find. Since,
    // either it will make the longest subarray, or it would be a single element subarray which we can check
    // using current index and the index from the map.
    public boolean checkSubarraySum(int[] nums, int k) {
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++)
        {
            currSum+=nums[i];
            currSum%=k;
            if(map.containsKey(currSum))
            {
                if(i - map.get(currSum)>=2)
                    return true;
                else
                    continue;
            }
            map.put(currSum, i);
        }
        return false;
    }
}
