package Leetcode.Tree;

/*
    IDEA : New BFS coding construct used. This loops over all the elements in a layer. Helps avoid using null
           and also makes some problems easier to implement including this.

           // REFER for explanation
*/

public class Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new ArrayDeque<>();
        
        int currNodeDist = 0;
        int maxi = 1;
        q.offer(new pair(root, 0));
        while(!q.isEmpty())
        {
            int size = q.size();
            int mini = q.peek().val;
            for(int i = 0; i<size; i++)
            {
                pair curr = q.poll();
            
                curr.val-=mini;
                
                maxi = Math.max(maxi, curr.val+1);
                if(curr.root.left!=null)
                    q.offer(new pair(curr.root.left, 2*curr.val+1));
                if(curr.root.right!=null)
                    q.offer(new pair(curr.root.right, 2*curr.val+2));
                
            }
            
        }
        return maxi;
    }
    private class pair
    {
        TreeNode root; int val;
        public pair(TreeNode r, int d)
        {
            root = r;
            val = d;
        }
    }
}
