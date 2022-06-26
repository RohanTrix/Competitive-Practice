/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // IDEA : Use BFS to serialize and deserialize the Binary tree.
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            list.add(curr == null?"N":Integer.toString(curr.val));
            if(curr != null) 
            {
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        for(String str : list)
            s.append(str+",");
        // System.out.println(s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String list[] = data.split(",");
        if(list.length == 1) return null;
        // System.out.println(Arrays.toString(list));
        
        Queue<TreeNode> q = new LinkedList<>();
        int k = 0;
        TreeNode root = new TreeNode(Integer.valueOf(list[0]));
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null) continue;
            TreeNode left, right;
            if(list[++k].charAt(0) == 'N')
                left = null;
            else
                left = new TreeNode(Integer.valueOf(list[k]));
            if(list[++k].charAt(0) == 'N')
                right = null;
            else
                right = new TreeNode(Integer.valueOf(list[k]));
            curr.left = left;
            curr.right = right;
            q.offer(left);
            q.offer(right);
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));