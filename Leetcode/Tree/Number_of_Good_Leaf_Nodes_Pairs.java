public class Number_of_Good_Leaf_Nodes_Pairs {
    // From every subtree, return a map of (dist+1) -> No. of nodes with that dist from current
    // When we are sending the map up by one edge we are increasing all distances by one
    int ans = 0, thresh;
    Map<Integer, Integer> dfs(TreeNode root)
    {
        if(root == null) return new HashMap<>();
        if(root.left == null && root.right == null)
            return new HashMap<>(Map.of(1,1));
        
        Map<Integer, Integer> left = dfs(root.left);
        Map<Integer, Integer> right = dfs(root.right);
        for(int dist1 : left.keySet())
        {
            for(int dist2 : right.keySet())
            {
                if(dist1+dist2<=thresh)
                    ans+=(left.get(dist1)*right.get(dist2));
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int dist : left.keySet())
            map.put(dist+1, map.getOrDefault(dist+1, 0)+left.get(dist));
        for(int dist : right.keySet())
            map.put(dist+1, map.getOrDefault(dist+1, 0)+right.get(dist));
        return map;
    }
    public int countPairs(TreeNode root, int distance) {
        this.thresh = distance;
        dfs(root);
        return ans;
        
    }
}
