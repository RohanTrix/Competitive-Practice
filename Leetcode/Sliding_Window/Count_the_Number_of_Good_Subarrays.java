import java.util.HashMap;
import java.util.Map;


// IDEA + INTUITION : https://youtu.be/k3ctPuOQJr4
// CODED by Self
public class Count_the_Number_of_Good_Subarrays {
    public long comb(int n) {
        return n * (n - 1) / 2;
    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        int left = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        long currCnt = 0;
        for (int right = 0; right < n; right++) {
            currCnt -= comb(map.getOrDefault(nums[right], 0));
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            currCnt += comb(map.get(nums[right]));

            while (left < right && currCnt >= k) {
                currCnt -= comb(map.get(nums[left]));
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                currCnt += comb(map.get(nums[left]));
                left++;
            }
            ans += left;
        }
        return ans;
    }
}