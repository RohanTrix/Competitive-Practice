/**
 *      IDEA : " nums[i] + c * space "....Is a simple way of saying that that no. has `c` cylces of `space` and remainder of `nums[i]`
 * 
 *              Now, let us think of mapping all the nums[i] to the MODULAR DOMAIN OF `space`.....this means that for a given remainder value
 *              rem = nums[i]%space    ---->    we shall be able to form all the numbers in the array which leave the same remainder rem when
 *              we do (that number % space)....Now, for example...in cycle of 1 in 2's space can be 1,3,5,7....now,
 *              if we have 1,3,5,7 in the array, then we would want to choose 1 instead of 3,5 or 7...since according to the question,
 *              1 can form all 4 of them.
 * 
 * 
 *              So simply we first count the max cnt of numbers having same modulus ( there can be more than 1)....among all the mods with maxcnt
 *              we want to take the smallest value in array which belongs to a mod with maxcnt.
 * 
 */

public class Destroy_Sequential_Targets {
    public int destroyTargets(int[] nums, int space) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
            map.put(nums[i]%space, map.getOrDefault(nums[i]%space, 0)+1);
        
        int maxcnt = Integer.MIN_VALUE;
        for(int key : map.keySet())
            maxcnt = Math.max(maxcnt, map.get(key));
        int ans = Integer.MAX_VALUE;
        for(int num : nums)
            if(map.get(num%space) == maxcnt)
                ans = Math.min(ans, num);
        return ans;
        
    }
}
