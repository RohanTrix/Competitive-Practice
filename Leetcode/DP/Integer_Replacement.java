public class Integer_Replacement
{
    // Using HashMap instead of DP array to avoid overflow
    Map<Long, Integer> dp = new HashMap<>();
    public int moves(long i)
    {
        if(i==1)return 0;
        if(dp.containsKey(i)) return dp.get(i);
        if(i%2==0) 
            dp.put(i, moves(i/2)+1);
        else
            dp.put(i, Math.min(moves(i+1), moves(i-1))+1);
        return dp.get(i);
    }
    public int integerReplacement(int n) {
        
        return moves((long)n);
    }
}