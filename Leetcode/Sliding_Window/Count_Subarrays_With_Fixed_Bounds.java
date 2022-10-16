/**
 *      REFER : https://leetcode.com/problems/count-subarrays-with-fixed-bounds/discuss/2708017/JAVA-Simple-one-pass-solution-explained-with-diagram.-O(N)-time-O(1)-space
 *      ALSO : https://youtu.be/aepocGE6WPc
 */

public class Count_Subarrays_With_Fixed_Bounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt = 0;
        int n = nums.length;
        int minInd = -1, maxInd = -1;
        int j = 0;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == minK)
                minInd = i;
            if(nums[i] == maxK)
                maxInd = i;
            
            if(nums[i]<minK || nums[i]>maxK)
            {
                minInd = -1;
                maxInd = -1;
                j = i+1;
            }
            if(minInd!=-1 && maxInd!=-1)
            {
                int prevValidBound = Math.min(minInd, maxInd);
                cnt+=prevValidBound - j+1;
            }
        }
        return cnt;
    }
}
