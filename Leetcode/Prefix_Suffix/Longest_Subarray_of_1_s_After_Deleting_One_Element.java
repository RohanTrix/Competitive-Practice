public class Longest_Subarray_of_1_s_After_Deleting_One_Element {
    // left[i] = Longest length of continuous ones ending at i from left
    // right[i] = Longest length of continuous ones ending at i from right
    // Ans[i] = left[i-1] + right[i-1]
    // We want the MAX( ans[i] )
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int cnt = 0;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 1)
                left[i] = ++cnt;
            else
            {
                left[i] = cnt = 0;
            }
        }
        cnt = 0;
        for(int i = n-1; i>=0; i--)
        {
            if(nums[i] == 1)
                right[i] = ++cnt;
            else
            {
                right[i] = cnt = 0;
            }
        }
        int maxi = 0;
        for(int i = 0; i<n; i++)
        {
            
            int l = 0, r = 0;
            if(i>0)
                l = left[i-1];
            if(i<n-1)
                r = right[i+1];
            maxi = Math.max(maxi, l+r);
        }
        return maxi;
    }
}
