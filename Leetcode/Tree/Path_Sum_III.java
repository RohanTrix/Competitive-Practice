public class Path_Sum_III
{
    //  IDEA : Count of  Subarray Sum Equals K technique
    int cnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public void dfs(TreeNode root, int currSum, int target)
    {
        if(root == null) return;
        currSum+=root.val;
        
        cnt+=map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
        dfs(root.left, currSum, target);
        dfs(root.right, currSum, target);
        map.put(currSum, map.getOrDefault(currSum, 0)-1);
        if(map.get(currSum) == 0) map.remove(currSum);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        map.put(0,1);
        dfs(root, 0, targetSum);
        return cnt;
    }
}