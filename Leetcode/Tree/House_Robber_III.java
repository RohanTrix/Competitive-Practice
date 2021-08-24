public class House_Robber_III {
    static class Pair
    {
        int without;
        int with;
        Pair(int with, int without)
        {
            this.with = with; // Stores answer WITH the current node
            this.without = without; // Stores answer WITHOUT current
        }
    }
    public Pair dfs(TreeNode root)
    {
        //If current node is null, we get 0 in both the cases.
        if(root==null)
            return new Pair(0,0); 

        // Gets the max sum of nodes with and without the node left
        Pair l = dfs(root.left); 

        // Gets max sum of nodes with and witrh
        Pair r = dfs(root.right);
        
        // MAX sum when curr node is taken is calculated from Sum of the above 2
        int withSubAns = l.without + r.without;
        
        // MAX sum when curr node is NOT taken is calculated from max of :
        //          1) Best sum of nodes when taking and not taking left child 
        //          2) Best sum of nodes taking and not taking right child 
        int withoutSubAns = Math.max(l.with, l.without) 
                            + Math.max(r.with, r.without);
        

        //Return Pair of (withSubAns + the value of current node,withoutSubAns)
        return new Pair(withSubAns + root.val, withoutSubAns);
        
    }
    public int rob(TreeNode root) {
        Pair fin = dfs(root);
        return Math.max(fin.with, fin.without);
    }
}
