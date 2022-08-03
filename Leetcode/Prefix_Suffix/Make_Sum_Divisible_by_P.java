package Leetcode.Prefix_Suffix;

public class Make_Sum_Divisible_by_P {
    // Explained in OneNote Subarray Problems
    public int minSubarray(int[] nums, int p) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,-1);
        long fullSum = 0;
        for(int num : nums) fullSum+=num;
        fullSum%=p;
        if(fullSum == 0) return 0;
        long currSum = 0;
        int n = nums.length, mini = n;
        for(int i = 0; i<n; i++)
        {
            currSum+=nums[i];
            currSum%=p;
            long newRem = (currSum-fullSum+p)%p;
            if(map.containsKey(newRem))
                mini = Math.min(mini, i - map.get(newRem));
            map.put(currSum, i);
        }
        return mini == n?-1:mini;
    }
}
