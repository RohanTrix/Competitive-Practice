class Solution {
    // REFER :- https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
    int moves = 0;
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        moves+=Math.abs(left) + Math.abs(right);
        int coinsInCurrSubTree = left + right + root.val;
        return coinsInCurrSubTree-1;
    }
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}