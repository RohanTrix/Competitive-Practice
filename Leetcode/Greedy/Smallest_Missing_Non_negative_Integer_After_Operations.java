import java.util.HashMap;
import java.util.Map;

/*
 *  IDEA : Adding or subtracting any value `value`, gives us the hint that we are playing in the 
 *         remainder cycles of the given value. So if value=5, then from a 2 we can form
 *              2+5, 2+5+5, 2+5+5+5 ....
 *         
 *         So the best idea is to collect the remainder info in a map with mapping rem  -> # of that rem in
 * 
 *         Next we greedily go from 0 to infinity, checking for the current value(possible MEX) that we need to
 *         form...if the curr%value remainder exists in the array, then that means we can form that num.
 *         So we curr++ and check for new curr.....but if we cannot, then that is the MEX
 *         
 */

public class Smallest_Missing_Non_negative_Integer_After_Operations {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            nums[i] = ((nums[i]%value)+value)%value;
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // System.out.println(map);
        int curr = 0, currRem = 0; // Curr is the current value..and currRem is which rem it belongs to
        while(true) {
            if(map.containsKey(currRem)) {
                map.put(currRem, map.get(currRem) - 1);
                if(map.get(currRem) == 0) map.remove(currRem);
                curr++;
                currRem++;
                currRem%=value;
            }
            else return curr;
        }
    }
}
