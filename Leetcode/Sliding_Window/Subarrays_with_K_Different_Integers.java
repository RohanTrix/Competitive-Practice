package Leetcode.Sliding_Window;
/**
 * IDEA : Sliding Window can be used to count number of subarrays with distinct elements <=k
 *         
 *        cntOfSubarrays(distinctCnt = k) ===== cntOfSubarrays(distinctCnt <= k) - cntOfSubarrays(distinctCnt <= k-1)
 */



import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_K_Different_Integers {
    int nums[];
    public int atMostKDistinct(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int cnt = 0;
        for(int right = 0; right<nums.length; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0)+1);
            while(left <= right && map.size() > k){
                int leftNum = nums[left++];
                map.put(leftNum, map.get(leftNum) - 1);
                if(map.get(leftNum) == 0) map.remove(leftNum);
            }
            cnt+=(right - left + 1);
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        this.nums = nums;
        return atMostKDistinct(k) - atMostKDistinct(k-1);
    }
}
