import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// IDEA : HashSet can be passed in recursion, we do not care about duplicate elements since we only care whether an element is present or not.
//        to check for abs diff.
public class The_Number_of_Beautiful_Subsets {
    int nums[], k;

    public int cnt(int i, Set<Integer> set) {
        if (i == -1)
            return 1;

        int ans = cnt(i - 1, set);
        if (!set.contains(nums[i] + k)) {
            set.add(nums[i]);
            ans += cnt(i - 1, set);
            set.remove(nums[i]);
        }
        return ans;
    }

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        Arrays.sort(nums);
        return cnt(nums.length - 1, new HashSet<>()) - 1;
    }
}
