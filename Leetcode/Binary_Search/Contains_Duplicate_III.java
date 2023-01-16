package Leetcode.Binary_Search;

import java.util.TreeMap;

/**
 *      IDEA : Whenenver we have <= or >= condition, it should be a hint for Binary Search or using a SORTED DS
 *  
 *             However, we have 2 conditions to take care of here. Thus, the idea is to force one condition
 *             to be always true. Since we can see that the indexDiff is a limitation, so we can imagine a fixed size
 *             sliding window...where we always compare the nums[right] with the window's elements.
 * 
 *             So we use a TreeMap of values -> cnt to denote the current window's elements. Since the window
 *             is of size (indexDiff+1)....we are sure that 2 elements inside this window will always have the
 *             constraint of indexes as true. Now, for an element x...I want a v such that:
 * 
 *                              |                   v      x               ----> Ceiling of (x-valueDiff) should be some value <=x
 *                              (x-valueDiff)
 * 
 *                              x                   v      |               ----> Floor of (x+valueDiff) should be some value >=x
 *                                                        (x+valueDiff)
 * 
 */
public class Contains_Duplicate_III
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Long, Integer> tm = new TreeMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            if(i>indexDiff)
            {
                Long v = (long)nums[i - indexDiff - 1];
                tm.put(v, tm.get(v) - 1);
                if(tm.get(v) == 0)
                    tm.remove(v);
            }
            
            Long num = (long)nums[i];
            
            Long floor = tm.floorKey(num + valueDiff);
            Long ceil  = tm.ceilingKey(num - valueDiff);
            if((floor!=null && num<=floor) || (ceil!=null && num>=ceil))
                return true;

            tm.put(num, tm.getOrDefault(num,0) + 1);
        }
        return false;
    }
}