public class Maximum_Product_of_Splitted_Binary_Tree
{
    // using dfs...find sum of each subtree
    // Then finally take maximum of each (subtree sum *(full tree sum - subtree sum))
    Map<Integer, Integer> map;
    int id;
    public int dfs(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        map.put(id, root.val+left+right);
        return map.get(id++);
    }
    public int maxProduct(TreeNode root) {
        int mod = (int)1e9+7;
        map = new HashMap<>();
        int full = dfs(root);
        long maxi = 0;
        for(int key : map.keySet())
            maxi = Math.max(maxi, (1L*map.get(key) * (full - map.get(key))) );
        return (int)(maxi%mod);
    }
}