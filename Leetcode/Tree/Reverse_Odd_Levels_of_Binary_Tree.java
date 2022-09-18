public class Reverse_Odd_Levels_of_Binary_Tree
{
    // IDEA : Keep track of which level you are at...at odd levels, reverse values of the list of nodes of that
    //        level
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.offer(root);
        List<TreeNode> list = new ArrayList<>();
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            list.clear();
            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();
                list.add(curr);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(level%2==1)
            {
                for(int i = 0; i<size/2; i++)
                {
                    int tmp = list.get(i).val;
                    list.get(i).val = list.get(size - i -1).val;
                    list.get(size - i -1).val = tmp;
                }
            }
            
            level++;
        }
        return root;
    }
}