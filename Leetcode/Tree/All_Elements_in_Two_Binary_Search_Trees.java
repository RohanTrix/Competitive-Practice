public class All_Elements_in_Two_Binary_Search_Trees
{
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        InorderTree t1 = new InorderTree(root1);
        InorderTree t2 = new InorderTree(root2);
        
        while(t1.hasNext() && t2.hasNext())
        {
            if(t1.current()<t2.current())
                res.add(t1.next());
            else
                res.add(t2.next());
        }
        while(t1.hasNext())
            res.add(t1.next());
        while(t2.hasNext())
            res.add(t2.next());
        return res;
    }
    private class InorderTree
    {
        Deque<TreeNode> stack;
        public InorderTree(TreeNode root)
        {
            stack = new ArrayDeque<>();
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
        }
        public boolean hasNext()
        {
            return !stack.isEmpty();
        }
        public int next()
        {
            TreeNode root = stack.pop();
            int val = root.val;
            root = root.right;
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            return val;
        }
        public int current()
        {
            return stack.peek().val;
        }
    }
}