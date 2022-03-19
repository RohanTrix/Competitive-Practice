// Using Normal BFS

public class Binary_Tree_Right_Side_View
{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        q.offer(null);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            
            if(curr!=null)
            {
                currList.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            else
            {
                if(currList.size()==0) break;
                ans.add(currList.get(currList.size()-1));
                currList.clear();
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return ans;
    }
}