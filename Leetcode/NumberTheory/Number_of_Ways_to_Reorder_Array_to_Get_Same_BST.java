public class Number_of_Ways_to_Reorder_Array_to_Get_Same_BST
{
    // IDEA : Explained in OneNote
    long fact[], ifact[];
    int mod = (int)1e9+7;
    public long binpow(long a, long b)
    {
        a%=mod;
        long res = 1;
        while(b>0)
        {
            if((b&1)==1)
                res = res * a % mod;
            a = a * a % mod;
            b>>=1;
        }
        return res;
    }
    public void init(int n)
    {
        fact = new long[n+1]; ifact = new long[n+1];
        fact[0] = 1; ifact[0] = 1;
        for(int i = 1; i<=n; i++)
        {
            fact[i] = (fact[i-1]*i)%mod;
            ifact[i] = binpow(fact[i], mod-2);
        }
    }
    public long nCr(int n, int r)
    {
        long ans = 1;
        ans = (ans * fact[n])%mod;
        ans = (ans * ifact[n-r])%mod;
        ans = (ans * ifact[r])%mod;
        return ans;
    }
    public long count(List<Integer> nums)
    {
        if(nums.size() == 0) return 1;
        
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        int root = nums.get(0);
        for(int i = 1; i<nums.size(); i++)
        {
            if(nums.get(i)< root)
                left.add(nums.get(i));
            else
                right.add(nums.get(i));
        }
        int leftSize = left.size(), rightSize = right.size();
        long ans = (nCr(leftSize+rightSize, leftSize)%mod * count(left)%mod * count(right)%mod)%mod;
        return ans%mod;
        
    }
    public int numOfWays(int[] nums) {
        init(nums.length);
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        return (int)count(list) - 1;
    }
}