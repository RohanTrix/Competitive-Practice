/**
 *      IDEA : Perform a DFS and create a Treemap that has the following mapping:
 *              
 *                      col -> List of (val, depth of node with this val)
 *            
 *             Now, go through the keys of the treemap...and sort the values of each list
 *             first based on the depth of the node...and then the value(for nodes in same col).
 *             Finally add value portions to a tmp list and add this tmp list to final ans.
 */

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    TreeMap<Integer, List<int[]>> map;
    public void dfs(TreeNode root,int dep, int col)
    {
        if(root == null)
            return;
        map.computeIfAbsent(col, k-> new ArrayList<>()).add(new int[]{root.val, dep});
        dfs(root.left,dep+1, col-1);
        dfs(root.right,dep+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root,0,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet())
        {
            List<int[]> vals = map.get(key);
            Collections.sort(vals, (a,b) -> a[1] == b[1]?a[0] - b[0]:a[1] - b[1]);
            List<Integer> tmp = new ArrayList<>();
            for(int item[] : vals)
                tmp.add(item[0]);
            ans.add(tmp);
        }
        return ans;
    }
}
