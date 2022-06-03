public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    // REFER : https://youtu.be/nxWT_mG-x54
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long pow[] = new long[n+1];
        pow[0] = 1;
        long mod = (int)1e9+7;
        // Precomputing powers of 2.
        for(int i = 1; i<=n; i++)
        {
            pow[i] = pow[i-1]*2;
            pow[i]%=mod;
        }

        long cnt = 0;
        int left = 0, right = n-1;
        while(left<=right)
        {
            if(nums[left]+nums[right]<=target)
            {
                System.out.println(left+" "+right);
                cnt+=pow[];
                cnt%=mod;
                left++;
            }
            else
                right--;
            System.out.println(cnt);
        }
        return (int)cnt;
        
    }
}
