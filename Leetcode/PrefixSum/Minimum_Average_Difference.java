public class Minimum_Average_Difference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long pref[] = new long[n+2];
        for(int i = 1; i<=n; i++) pref[i] = pref[i-1]+nums[i-1];
        
        long mini = Long.MAX_VALUE/2;
        int idx = 0;
        for(int i = 1; i<=n; i++)
        {
            long left = pref[i];
            long right = pref[n] - pref[i];
            // System.out.println(left+ " "+right);
            if(n==i)
            {
                if(pref[n]/n <mini) idx = n-1;
            }
            else if( Math.abs((left/(i)) - (right/(n-i))) < mini)
            {
                mini = Math.abs((left/(i)) - (right/(n-i)));
                idx = i-1;
            }
        }
        return idx;
    }
}
