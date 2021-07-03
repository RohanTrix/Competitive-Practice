
import java.util.*;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        int s = 0, left =0, maxi = -1;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int right = 0; right<n;right++)       
        {
            s+=nums[right];
            while(right> left && hs.contains(nums[right]))
            {
                hs.remove(nums[left]);
                s-=nums[left];
                left++;
            }
            //System.out.println(s);
            hs.add(nums[right]);
            maxi = Math.max(maxi, s);
            
        }
        return maxi;
        
    }
}