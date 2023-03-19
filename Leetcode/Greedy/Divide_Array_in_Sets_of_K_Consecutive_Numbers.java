package Leetcode.Greedy;

import java.util.TreeMap;


// IDEA: Build a treemap. We greedily pick the lowest key, since the seq has to start from there,
//       and then remove k elements consecutively if you can. Read cpde to understand better
public class Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int num : nums)
            tm.put(num, tm.getOrDefault(num,0)+1);
        while(!tm.isEmpty()) {
            int low = tm.firstKey();
            for(int i = 0; i<k; i++) {
                if(!tm.containsKey(low)) return false;
                tm.put(low, tm.get(low) - 1);
                if(tm.get(low) == 0)
                    tm.remove(low);
                low++;
            }
        }
        return true;
    }
}
