public class Largest_BST_Subtree
{
    Tree ans;
    int maxi = 0;
    // IDEA : Little Tricky problem
    // returns {T/F, MIN, MAX, cnt}
    //          1. T/F whether current subtree is a BST or not (represented as 1/0)
    //          2. MIN element in the current subtree
    //          3. MAX element in the current subtree
    //          4. Count of nodes in current subtree
    //          Base case : For null nodes....we can say range of [MIN, MAX] = {INTMAX, INTMIN};
    public int[] dfs(Tree root)
    {
        if(root == null)
            return new int[]{1,(int) 1e9, (int)-1e9, 0};
        
        int left[] = dfs(root.left);
        int leftMin = left[1], leftMax = left[2]; // Range of values for left subtree
        int right[] = dfs(root.right);
        int rightMin = right[1], rightMax = right[2]; // Range of values for right subtree

        // If both subtrees are BST and the root's val is a valid val that lies in the range [leftMax, rightMin]
        if(left[0] == 1 && right[0] == 1 && root.val>leftMax && root.val<rightMin)
        {
            int totNodes = left[3]+right[3]+1;
            if(totNodes>maxi)
            {
                maxi = totNodes;
                ans = root;
            }
            return new int[]{1, Math.min(leftMin, root.val), Math.max(rightMax, root.val), totNodes};
        }
        else // Since this subtree cannot be BST, we return 0 as F value. Other values we do not care about if it ain't a BST
            return new int[]{0, 0,0,0};

    }
    public Tree solve(Tree root) {
        dfs(root);
        return ans;
    }
}