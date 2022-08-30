public class Count_of_Range_Sum {
    // EXPLANATION TO BE WRITTEN IN ONENOTE
    /w
    // Deduce from low <= sum(i,j) <= high
    class Fenwick
    {
        int size;
        long bit[];
        public Fenwick(int n)
        {
            bit = new long[n+1];
            size = n;
        }
        public void update(int pos, int val)
        {
            while(pos<=size)
            {
                bit[pos]+=val;
                pos+=Integer.lowestOneBit(pos);
            }
        }
        public int sum(int pos)
        {
            int res = 0;
            while(pos>0)
            {
                res+=bit[pos];
                pos-=Integer.lowestOneBit(pos);
            }
            return res;
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long pref[] = new long[n+1];
        for(int i = 1; i<=n; i++) pref[i] = pref[i-1]+nums[i-1];
        Arrays.sort(pref);
        n = pref.length;
        Fenwick ft = new Fenwick(n);
        ft.update(lower_bound(pref, 0)+1, 1);
        long currSum = 0;
        int ans = 0;
        for(int i = 0; i<nums.length; i++)
        {
            currSum+=nums[i];
            int R = ft.sum(lower_bound(pref, currSum - lower + 1) );
            int L = ft.sum(lower_bound(pref, currSum - upper));
            ans+= R - L;
            ft.update(lower_bound(pref, currSum)+1, 1);
        }
        return ans;
    }
    public int lower_bound(long pref[], long key)
    {
        int l = 0, r = pref.length-1;
        int ind = pref.length;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(pref[mid]>=key)
            {
                ind = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return ind;
    }
}
