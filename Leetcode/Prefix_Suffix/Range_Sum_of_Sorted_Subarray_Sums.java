class Solution {
    /* ALGO: Use the Prefix Sum concept to calculate the values for the array containing the 
     * sum of all non-empty subsarrays.
     * Now, use a Prefix Sum again on this newly created array, and return prefSub[right] - prefSub[left-1]
     * Always create Prefix sum array of size n+1 for ease.
    */

    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        int subSums[] = new int[n*(n+1)/2];
        int pref[] = new int[n + 1];
        pref[0] = 0;
        for(int i = 1;i<=n;++i) pref[i] = nums[i-1] + pref[i-1];
        int k =0;
        for( int i = 1;i<=n;i++)
            for(int j = i;j<=n;j++)
            {
                //System.out.println(pref[i]+","+pref[j]+" ");
                subSums[k++] = pref[j] - pref[i-1];
            }
        Arrays.sort(subSums);
        int prefSub[] = new int[n*(n+1)/2 + 1];
        prefSub[0] = 0;
        for(int i = 1;i<=n*(n+1)/2;++i) prefSub[i] = (subSums[i-1] + prefSub[i-1])%MOD;
        
        //System.out.println(Arrays.toString(prefSub));
        return (prefSub[right] - prefSub[left-1]) %MOD;           
    }
}