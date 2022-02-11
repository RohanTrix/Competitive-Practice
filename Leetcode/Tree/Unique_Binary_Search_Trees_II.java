public class Unique_Binary_Search_Trees_II
{
    // REFER : https://youtu.be/mhCJgZWJlSI
    public List<TreeNode> gen(int start, int end)
    {
        List<TreeNode> currlist = new ArrayList<>();

        if(start>end)
        {
            currlist.add(null);
            return currlist;
        }
        for(int i =start; i<=end; i++)
        {
            List<TreeNode> leftSubTrees = gen(start, i-1);
            List<TreeNode> rightSubTrees = gen(i+1, end);

            for(TreeNode left : leftSubTrees)
            {
                for(TreeNode right : rightSubTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    currlist.add(root);
                }
            }
        }
        return currlist;
    }
    public List<TreeNode> generateTrees(int n) {
        return gen(1,n);
    }
}