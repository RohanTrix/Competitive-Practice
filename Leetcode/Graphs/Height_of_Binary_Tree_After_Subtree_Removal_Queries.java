
// REFER FOR LOGIC : https://youtu.be/s62a0uxeRkE
public class Height_of_Binary_Tree_After_Subtree_Removal_Queries {
    Map<Integer, Integer> nodeCnt; // Cnt of nodes under node's subtree
    Map<Integer, Integer> dep; // Depth of each node from top
    List<Integer> tour; // Euler Tour Array of the Tree
    public void dfs(TreeNode root, int depth)
    {
        if(root == null) return;
        dep.put(root.val, depth);
        tour.add(root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public int dfs2(TreeNode root)
    {
        if(root == null) return 0;
        nodeCnt.put(root.val, 1 + dfs2(root.left) + dfs2(root.right));
        return nodeCnt.get(root.val);
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        nodeCnt = new HashMap<>();
        dep = new HashMap<>();
        tour = new ArrayList<>();
        dfs(root, 0);
        dfs2(root);
        int n = tour.size();
        Map<Integer, Integer> nodeIdx = new HashMap<>();
        for(int i =0; i<n; i++)
            nodeIdx.put(tour.get(i), i);
        
        int prefMax[] = new int[n];
        prefMax[0] = dep.get(tour.get(0));
        for(int i = 1; i<n; i++)
            prefMax[i] = Math.max(prefMax[i-1], dep.get(tour.get(i)));
        
        int suffMax[] = new int[n];
        suffMax[n-1] = dep.get(tour.get(n-1));
        for(int i = n-2; i>=0; i--)
            suffMax[i] = Math.max(suffMax[i+1], dep.get(tour.get(i)));
        
        int q = queries.length;
        int ans[] = new int[q];
        for(int i = 0; i<q; i++)
        {
            int l = nodeIdx.get(queries[i]);
            int r = l + nodeCnt.get(queries[i]) - 1;
            int leftMax = l-1>=0?prefMax[l-1]:Integer.MIN_VALUE;
            int rightMax = r+1<n?suffMax[r+1]:Integer.MIN_VALUE;
            ans[i] = Math.max(leftMax, rightMax);
        }
        return ans;
}
