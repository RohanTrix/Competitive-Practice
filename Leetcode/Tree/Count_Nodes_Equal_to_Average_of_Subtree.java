public class Count_Nodes_Equal_to_Average_of_Subtree {
    int ans = 0;
    // Function returns [totalSum, totCnt] of all elements from current nodes' subtree(including itself);
    public int[] dfs(TreeNode root)
    {
        if(root == null) return new int[]{0,0};
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        int totSum = left[0]+right[0]+root.val;
        int totCnt = left[1]+right[1]+1;
        ans+=(totSum/totCnt==root.val)?1:0;
        return new int[]{totSum, totCnt};
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
