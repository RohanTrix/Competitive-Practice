/*
    IDEA : We can see that if we partition at the operators,
           then if we have all different results of the left half and all different results of
           the right half, then we can COMBINE(using the operator we partioned at) 
           each result in the left half and each result in the right half to find
           out the different answers for the entire string.

           DP STATE : dp[i][j] = List of possible results for s[i...j]

*/
public class Different_Ways_to_Add_Parentheses {
    Map<pair,List<Integer>> map;
    char s[];
    String ops = "-+*";
    public List<Integer> ways(int i, int j)
    {
        boolean b = true;
        StringBuilder num = new StringBuilder();
        for(int p = i; p<=j;p++)
        {
            if(ops.contains(""+s[p])) b = false;
            num.append(s[p]);
        }
        if(b)
        {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.valueOf(num.toString()));
            
            map.put(new pair(i,j), list);
            return list;
        }
        if(map.containsKey(new pair(i,j))) return map.get(new pair(i,j));
        
        List<Integer> res = new ArrayList<>();
        for(int p = i+1; p<j;p++)
        {
            if(!ops.contains(""+s[p])) continue;
            List<Integer> left = ways(i,p-1);
            List<Integer> right = ways(p+1, j);
            for(int u : left)
            {
                for(int v : right)
                {
                    if(s[p] == '-')
                        res.add(u-v);
                    else if(s[p] == '+')
                        res.add(u+v);
                    else
                        res.add(u*v);
                }
            }
        }
        map.put(new pair(i,j), res);
        return res;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        map = new HashMap<>();
        s = expression.toCharArray();
        return ways(0, s.length-1);
    }
    private class pair
    {
        int i, j;
        public pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof pair)) return false;
            pair that = (pair)o;
            return i == that.i && j == that.j;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
        public String toString()
        {
            return i+" "+j;
        }
    }
}
