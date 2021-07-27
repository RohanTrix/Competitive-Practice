class _3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int bestAns = -target;
        if(target==0)bestAns = Integer.MAX_VALUE/2;
        for(int i = 0; i<n-2; i++)
        {
            int l = i+1;
            int r = n-1;
            while(l<r)
            {
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(sum-target)<Math.abs(bestAns-target))bestAns = sum;
                if(sum==target) return sum;
                if(sum<target)l++;
                else r--;
            }
        }
        return bestAns;
    }
}
