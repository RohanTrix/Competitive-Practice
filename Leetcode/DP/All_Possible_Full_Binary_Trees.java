public class All_Possible_Full_Binary_Trees {
    // REFER : https://youtu.be/VYczyMiMTqA
    // REFER : https://youtu.be/F0dUVxzzg_M
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0) return new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        if(n == 1)
        {
            
            res.add(new TreeNode(0));
            return res;
        }
        
        for(int i = 1; i<n; i+=2) // <n since one node we are using as root.
        {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            System.out.println("n = "+n+ " "+left.size()+" "+right.size());
            for(TreeNode leftTree : left)
            {
                for(TreeNode rightTree : right)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
