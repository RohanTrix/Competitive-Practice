
/*


*/

public class Find_Duplicate_Subtrees {
    Map<String, Integer> counter = new HashMap<>();
    Map<String, TreeNode> mapper = new HashMap<>();
    
    public String treeStore(TreeNode root)
    {
        if(root == null) return "NULL";
        
        String leftSubTree = treeStore(root.left);
        String rightSubTree = treeStore(root.right);
        
        String currTree = "" + root.val + "#" + leftSubTree + "#" + rightSubTree;
        
        counter.put(currTree, counter.getOrDefault(currTree,0)+1);
        mapper.put(currTree, root);
        
        return currTree;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        treeStore(root);
        
        for(String key : counter.keySet())
        {
            if(counter.get(key) > 1)
            {
                res.add(mapper.get(key));
            }
        }
        return res;
    }
}
