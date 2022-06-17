/**
 *      TOUGH TREE DP PROBLEM
 *      REFER LOGIC ONLY : https://youtu.be/WB5LUPTU5Yk
 */

public class Binary_Tree_Cameras {
    Map<State, Integer> dp;
    public int minCost(TreeNode root, boolean camHere, boolean parentCam)
    {
        if(root == null) return camHere?(int)1e5:0;

        State curr = new State(root.val, camHere, parentCam);
        if(dp.containsKey(curr))
            return dp.get(curr);
        
        if(camHere) // Ans should be 1 + (minCam in left subtree) + (minCam in rightSubtree)
        {
            int minCamLeft = Math.min(minCost(root.left,true,true), minCost(root.left, false, true));
            int minCamRight = Math.min(minCost(root.right, true, true), minCost(root.right, false, true));
            dp.put(curr, 1+minCamLeft+minCamRight);
        }
        else
        {
            if(parentCam)
            {
                int minCamLeft = Math.min(minCost(root.left,true,false), minCost(root.left, false, false));
                int minCamRight = Math.min(minCost(root.right, true, false), minCost(root.right, false, false));
                dp.put(curr, minCamLeft+minCamRight);
            }
            else
            {
                int mini = (int)1e5;
                // Left child has cam
                int minCamLeft = minCost(root.left, true, false);
                int minCamRight = Math.min(minCost(root.right, true, false), minCost(root.right, false, false));
                mini = Math.min(mini, minCamLeft+minCamRight);
                
                // Right Child has cam
                minCamLeft = Math.min(minCost(root.left, true, false), minCost(root.left, false, false));
                minCamRight = minCost(root.right, true, false);
                mini = Math.min(mini, minCamLeft+minCamRight);
                
                dp.put(curr, mini);
            }
        }
        return dp.get(curr);
    }
    int id;
    public void idAssign(TreeNode root)
    {
        if(root == null) return;
        root.val = id++;
        idAssign(root.left);
        idAssign(root.right);
    }
    public int minCameraCover(TreeNode root) {
        dp = new HashMap<>();
        id = 0;
        idAssign(root);
        return Math.min(minCost(root, true, false), minCost(root, false, false));
    }
    class State
    {
        int node;
        boolean camHere,parentCam;
        public State(int node, boolean camHere, boolean parentCam)
        {
            this.node = node;
            this.camHere = camHere;
            this.parentCam = parentCam;
        }
        public boolean equals(Object o)
        {
            State p = (State) o;
            return node == p.node && camHere == p.camHere && parentCam == p.parentCam;
        }
        public int hashCode()
        {
            return Objects.hash(node)^Objects.hash(camHere, parentCam);
        }
    }
}
