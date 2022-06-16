/**
 *      // Solved on LintCode
 *      IDEA : 
 *              1. Add root to ans
 *              2. Add Left boundary of Tree excluding leaf node
 *              3. Add Leaf nodes of Tree
 *              4. Add Right Boundary of Tree excluding root and leaf node recusively in reverse order.
 */

public class Boundary_of_Binary_Tree
{
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.val);
        // write your code here
        leftBoundary(root.left, ans);
        // System.out.println(ans);
        bottomBoundary(root, ans);
        // System.out.println(ans);
        rightBoundary(root.right, ans);
        // System.out.println(ans);
        return ans;
    }
    public void rightBoundary(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.right!=null) rightBoundary(root.right, ans);
        else rightBoundary(root.left, ans);
        ans.add(root.val);
    }
    public void bottomBoundary(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            ans.add(root.val);
            return;
        }
        bottomBoundary(root.left, ans);
        bottomBoundary(root.right, ans);
    }
    public void leftBoundary(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
            return;
        ans.add(root.val);
        if(root.left!=null) leftBoundary(root.left, ans);
        else leftBoundary(root.right, ans);
    }
}