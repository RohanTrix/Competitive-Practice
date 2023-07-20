import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
// IDEA : Form Child to parent links and then do a BFS from target node. Append all the k distance nodes that come in that BFS
class Solution {
    Map<TreeNode, TreeNode> map;
    
    public void dfs1(TreeNode root) {
        if(root == null) return;
        if(root.left!=null) {
            map.put(root.left, root);
            dfs1(root.left);
        }
        if(root.right!=null) {
            map.put(root.right, root);
            dfs1(root.right);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        dfs1(root);
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        
        int level = 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i<n; i++) {
                TreeNode curr = q.poll();
                if(level == k){
                    ans.add(curr.val);
                    continue;
                }
                if(curr.left!=null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(map.containsKey(curr) && !visited.contains(map.get(curr))) {
                    q.offer(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            level++;
        }
        return ans;

    }
}