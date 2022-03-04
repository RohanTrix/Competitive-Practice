// IDEA : Take full xor of array, and on each iteration xor last element to remove it from xor.
//        Rest, to maximise....where there is 1 in full xor, we should have 0 and vice versa

public class Maximum_XOR_for_Each_Query
{
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int full_xor = 0;
        for(int i : nums) full_xor^=i;
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            int res = 0;
            for(int k = 0 ;k<maximumBit; k++)
            {
                if((full_xor & (1 << k)) ==0) 
                    res = res | (1<<k);
            }
            ans[i] = res;
            full_xor ^=nums[n-i-1];
        }
        return ans;
    }
}