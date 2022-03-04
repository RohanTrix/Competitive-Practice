/*
    IDEA : Perform DFS from each node and go on marking their colors
*/
public class Is_Graph_Bipartite {
    Set<Integer> vis = new HashSet<>();
    int color[];
    public boolean dfs(int u, int col, int graph[][])
    {
        if(vis.contains(u))
        {
            return color[u] == col;
        }
        vis.add(u);
        color[u] = col;
        boolean ans = true;
        for(int to : graph[u])
        {
            ans = dfs(to,1^col, graph) && ans;
        }
        return ans;
    }
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        Arrays.fill(color, -1);
        boolean ans = true;
        for(int i = 0; i<graph.length; i++)
        {
            if(!vis.contains(i))
            {
                ans = dfs(i,0,graph) && ans;
            }
        }
        return ans;
    }
}
