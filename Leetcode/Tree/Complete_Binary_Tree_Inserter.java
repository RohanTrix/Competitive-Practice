/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// REFER : https://youtu.be/x9wAMfcGI8A
public class Complete_Binary_Tree_Inserter {
    TreeNode root;
    Queue<TreeNode> q;
    public CBTInserter(TreeNode r) { // O(N) building of tree
        
        q = new LinkedList<>();
        this.root = r;
        q.offer(root);
         while (true) 
         {
            TreeNode cur = q.peek();
            // We only want to keep elements of the second last layer in the queue
            if (cur.left != null && cur.right != null) { 
                q.offer(cur.left);
                q.offer(cur.right);
                q.poll();
            } else {
                break;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode tmp = q.peek();
        if(tmp.left==null) // If left node not present, attach new node to left node
        {
            tmp.left = newNode;
        }
        else if(tmp.right==null) // Attach right node is not present, and pop parent out the the queue
        {
            tmp.right = newNode;
            q.offer(tmp.left);
            q.offer(tmp.right);
            q.poll();
        }
        return tmp.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */