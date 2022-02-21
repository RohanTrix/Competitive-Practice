/*
    IDEA : For every node, we store
            1) length of path going down if we take a left from here
            2) length of path going down if we take a right from here

            By doing this, if this node is a right child of its parent,
            then parent's length of path going down on taking a right will be this node's
            answer on going left. And similarly for the right child.

           
*/
public class Longest_ZigZag_Path_in_a_Binary_Tree {
    int maxi = 0;
    public int[] longest(TreeNode root)
    {
        if(root == null) return new int[]{-1,-1};
        int left[] = longest(root.left);
        int right[] = longest(root.right);
        
        int ans[] = new int[2];
        ans[0] = 1 + left[1];
        ans[1] = 1 + right[0];
        maxi = Math.max(maxi,Math.max(ans[0], ans[1]));
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        longest(root);
        return maxi;
    }
}
