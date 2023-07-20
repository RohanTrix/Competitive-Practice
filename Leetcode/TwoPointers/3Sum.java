import java.util.*;

/*
 *  IDEA : We can go upto n^2 accodring to constraints. So we choose nums[i] with a single traversal.
 *         Now, since we have sorted the array, finding a nums[j] + nums[k] = goal(nums[i]) is a 2 pointer problem.
 *         But we need to be careful not to take duplicates. Hence, once we find a suitable nums[j] and nums[k],
 *         we add it to our answer and skip all the same nums[j] and same nums[k] (since they cannot pair with any other number except each other)
 *         We also have to take care of not using nums[i] again...since in the first appearance of nums[i] we will have added
 *         all the combinations.
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            int j = i+1, k = n-1;
            //If number is getting repeated, ignore the lower loop and continue.
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            
            while(j<k) {
                if(nums[i]+nums[j]+nums[k] == 0) {
                    int num2 = nums[j], num3 = nums[k];
                    List<Integer> tmp = List.of(nums[i], nums[j], nums[k]);
                    ans.add(tmp);
                    while(j<k && nums[j]==num2) j++; // Skip same nums[j]
                    while(j<k && nums[k]==num3) k--; // Skip same nums[k]
                    
                }
                else if(nums[j]+nums[k] < -nums[i]) j++;
                else k--;
            }
        }
        return ans;
    }
}