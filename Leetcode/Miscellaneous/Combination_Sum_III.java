import java.util.*;
class Combination_Sum_III {
    
    List<List<Integer>> res = new ArrayList();
    
    public void backtrack(int k, int sum, ArrayList<Integer> curr, int ind)
    {
        if(sum==0 && k==0)
        {
            res.add(new ArrayList(curr));
            return;
        }
        if(k==0) return;
        
        for(int i = ind; i<10; i++)
        {
            if(i<=sum)
            {
                curr.add(i);
                backtrack(k-1, sum-i,curr, i+1);
                curr.remove(curr.size()-1);
            }
            else break;
        }
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,new ArrayList<Integer>(), 1);
        return res;
        
    }
}