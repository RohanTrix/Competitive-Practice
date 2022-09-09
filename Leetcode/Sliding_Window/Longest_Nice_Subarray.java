public class Longest_Nice_Subarray
{
    // IDEA : Slinding window while maintaining a bitcount array. Increase window everytime, decrease
    //        window until count array is valid (no set bit occurs more than once)
    public boolean valid(int count[])
    {
        for(int num : count) if(num > 1) return false;
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        int count[] = new int[31];
        int left = 0, maxi = 1;
        int n = nums.length;
        for(int right = 0;right<n; right++)
        {
            for(int j = 0; j<31; j++)
                if((nums[right]&(1<<j))!=0)
                    count[j]++;
            
            while(left < right && !valid(count))
            {
                for(int j = 0; j<31; j++)
                    if((nums[left]&(1<<j))!=0)
                        count[j]--;
                left++;
            }
            // System.out.println(Arrays.toString(count));
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
}