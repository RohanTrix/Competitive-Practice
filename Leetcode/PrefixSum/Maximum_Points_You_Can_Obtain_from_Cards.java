class Maximum_Points_You_Can_Obtain_from_Cards {
    // IDEA: Taking out items from beginning or end is same as finding out 
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        k = n-k;
        int prefSum[] = new int[n+1];
        prefSum[0] = 0;
        for(int i =1; i<=n;i++) prefSum[i] = prefSum[i-1]+nums[i-1];
        int mini = Integer.MAX_VALUE;
        for( int i = k; i<=n;i++)
        {
            mini = Math.min(mini, prefSum[i]-prefSum[i-k]);
        }
        return prefSum[n] - mini;
    }
}