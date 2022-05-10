import java.util.*;
class Combination_Sum_III {
    
    List<List<Integer>> res = new ArrayList<>();
    public void recur(int ind, int k, int n, List<Integer> curr)
    {
        if(n == 0 && k==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(n<0 || ind==10) return;
        recur(ind+1, k, n, curr);
        curr.add(ind);
        recur(ind+1, k-1, n-ind, curr);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        recur(1, k, n, new ArrayList<>());
        return res;
    }
}