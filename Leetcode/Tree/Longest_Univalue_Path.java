/*
    IDEA : Kind of Tree DP type idea. We want the child of a parent to return which value it contains
           and the longest path going down which contains these values.
           Now if the parent has the same value in its node, then he can add to the distance from the child.
           
           So we get the pair {val, len} from both left and right child. And using current's value
           (if only it is same as any of its child's returned value) we can take a max length that can be formed
           by a path which passes from current root. Similar to diameter of a binary tree idea. 
*/


public class Longest_Univalue_Path {
    int maxi = 0;
    public int[] dfs(TreeNode root)
    {
        if(root == null) return new int[]{-10000,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int ans[] = new int[]{root.val, 1};
        if(left[0] == root.val)
            ans[1]+=left[1];
        else
            left[1] = 0;
        if(right[0] == root.val)
            ans[1]+=right[1];
        else
            right[1] = 0;
        
        maxi = Math.max(ans[1], maxi);
        ans[1] = 1+Math.max(left[1], right[1]);
        return ans;
        
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return Math.max(0,maxi-1);
    }
}