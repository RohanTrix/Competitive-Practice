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
public class Increasing_Order_Search_Treetion {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currNode = root;
        boolean done = false;
        if(root ==null || (root.left==null && root.right==null))
            return root;
        while(!done)
        {
            if(currNode != null)
            {
                s.push(currNode);
                currNode = currNode.left;
            }
            else
            {
                if(s.isEmpty())
                    done = true;
                else
                {
                    currNode = s.pop();
                    res.add(currNode);
                    currNode = currNode.right;
                }
            }
        }
        //res.add(null);
        for(TreeNode i: res) System.out.print(i.val + " ");
        root = res.get(0);
        currNode = root;
        for(int i = 1;i<res.size();i++)
        {
            currNode.left = null;
            currNode.right = res.get(i);
            currNode = currNode.right;
        }
        currNode.left = null;
        currNode.right = null;
        return root;           
    }
}