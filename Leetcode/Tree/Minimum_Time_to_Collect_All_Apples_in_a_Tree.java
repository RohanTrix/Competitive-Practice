/*
    IDEA : The idea is that a node should return in some way if there was at least
           one apple in its subtree. If yes, then we know that edge between
           this node and its parent will have to be travelled twice, once to go to the subtree to visit
           all apples in the subtree and once more to come back to parent node.

           So from a current node, if we call a DFS to its children, then the children which return true
           denotes that there subtree contains at least one node that has an apple. So the edge between 
           current node and this child will be traversed twice.

*/
public class Minimum_Time_to_Collect_All_Apples_in_a_Tree
{
    Map<Integer, List<Integer>> edges = new HashMap<>();
    int finAns = 0;
    public boolean dfs(int u, int par, List<Boolean> hasApple)
    {
        int cnt = 0;
        for(int to : edges.get(u))
        {
            if(to!=par)
            {
                if(dfs(to, u, hasApple))
                    cnt+=2;
            }
        }
        finAns+=cnt;
        // Either the node's subtree has an apple or the node itself(as its also a part of its subtree)
        if(cnt!=0 || hasApple.get(u)) return true;
        return false;
        
    }
    public int minTime(int n, int[][] eds, List<Boolean> hasApple) {
        for(int i = 0; i<n; i++)
            addNode(i);
        for(int edge[]: eds)
            addEdge(edge[0], edge[1]);
        
        dfs(0, -1, hasApple);
        return finAns;
        
    }
    public void addNode(int u)
    {
        edges.put(u, new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}