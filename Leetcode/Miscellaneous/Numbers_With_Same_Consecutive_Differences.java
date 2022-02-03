
// IDEA: Simple dfs starting at every digit except 0. Special case, do on 1 dfs if k=0,
//       otherwise duplication of final values occurs

public class Numbers_With_Same_Consecutive_Differences {
    List<Integer> res = new ArrayList<>();
    public void dfs(String num,int n, int dig, int k)
    {
        if(dig<0 || dig>9)return;
        num+=String.valueOf(dig);
        if(n==0)
        {
            res.add(Integer.valueOf(num));
            return;
        }
        if(k!=0)
            dfs(num,n-1,dig+k, k);
        dfs(num, n-1,dig-k, k);
    }
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i<=9; i++)
            dfs("", n-1,i,k);
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}
