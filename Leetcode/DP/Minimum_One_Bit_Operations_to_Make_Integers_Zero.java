public class Minimum_One_Bit_Operations_to_Make_Integers_Zero
{
    // REFER FOR EXPLANATION : https://youtu.be/Lp2pncT8FXc
    Map<Integer, Integer> dp;
    public int minMoves(int n)
    {
        if(n == 0) return 0;
        if(dp.containsKey(n)) return dp.get(n);
        
        int msb = Integer.highestOneBit(n);
        int ans = minMoves(msb) - minMoves(n-msb);
        dp.put(n, ans);
        return ans;
    }
    public int minimumOneBitOperations(int n) {
        dp = new HashMap<>();
        dp.put(1,1);
        for(int i = 2; i<(1<<30); i*=2)
            dp.put(i, 2*dp.get(i/2)+1);
        return minMoves(n);
    }
}