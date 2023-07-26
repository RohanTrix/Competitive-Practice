import java.util.ArrayList;
import java.util.List;

/**
 *      IDEA : Cyclic Sort used. Think about cyclic sort whenever array elements are in range [1,n] and constant space soln is needed.
 *             So we know there are 2 types of elements. ONe which appears once and another appearing twice.
 *             In our array, we want to rearrange elements such that ith index contains the (i+1)th element. Like this,
 *             one appearance of each element will get allocated to its correct position(using cycle sort).
 *             Finally, in another loop we can find which elements are incorrectly displaced..and they are the repeating elements.
 * 
 */

public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        // Cylic Sort
        for(int i = 0; i<n; i++) {
            // Keep cycling until the the (nums[i] - 1)th position does not have correct element
            while(nums[nums[i] - 1]!=nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        // Add incorrectly displaced items since they are the duplicate ones
        for(int i = 0; i<n; i++)
            if(nums[i]!=i+1) ans.add(nums[i]);
        return ans;
    }
}