package Leetcode.Prefix_Suffix;

import java.util.HashMap;
import java.util.Map;

// IDEA : Explained in OneNote in Subarray Section
// Also refer discuss section

public class Longest_Well_Performing_Interval {
    public int longestWPI(int[] hours) {
        int currSum = 0, maxlen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<hours.length; i++)
        {
            currSum+=hours[i] > 8 ? 1: -1;

            if(currSum>0)
                maxlen = Math.max(maxlen, i+1);
            else if(map.containsKey(currSum-1))
                maxlen = Math.max(maxlen, i - map.get(currSum-1));
            map.putIfAbsent(currSum, i);
        }
        return maxlen;
    }
}
