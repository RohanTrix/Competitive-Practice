package Leetcode.Tree;

/*
    IDEA : It is kind of like a binary search, or more like elemination of subtrees.
           As a base case, if the given TreeNode is a null node, then answer is 0.

           Next, we find height of left subtree and right subtree. If the heights are equal, then
           that means that the rightsubtree will have the last node of the last row. This means,
           that using the height of the left subtree, we can count how many nodes the left subtree has
           (since the subtree is also a complete binary tree). If that is not the case, then we know that
           the last node of the last row will be in left subtree, and we can count the nodes of the right subtree 
           using its height by the formula given below. In both cases, we need to add an extra 1 for the current
           root node.

           Formula to get no. of nodes in a binary tree with all levels filled completely = 2^h - 1

           Formula can be derived using GP.



*/
public class Count_Complete_Tree_Nodes {
    public int getHeight(TreeNode root)
    {
        if(root== null) return 0;
        return 1 + getHeight(root.left);
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int hleft = getHeight(root.left);
        int hright = getHeight(root.right);
        if(hleft>hright)
            return countNodes(root.left) + ((int) Math.pow(2,hright) -1 )+1;
        else
            return countNodes(root.right) + ((int)Math.pow(2,hleft) -1) + 1;
    }
}
