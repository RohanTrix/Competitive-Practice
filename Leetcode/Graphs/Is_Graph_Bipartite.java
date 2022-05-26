/*
    IDEA : Perform DFS from each unvisited node and go on marking their colors alternatively during recursion
    
    Alternate IDEA : BFS
*/
public class Is_Graph_Bipartite {
    int color[];
    public boolean dfs(int u, int par, int currCol, int[][] graph)
    {
        if(color[u]!=-1)
            return color[u] ==currCol;
        boolean ans = true;
        color[u] = currCol;
        for(int to : graph[u])
                ans = ans && dfs(to, u, 1^currCol, graph);
        return ans;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i<n; i++)
        {
            if(color[i] == -1)
                if(!dfs(i,-1, 0, graph)) return false;
        }
        return true;
    }
}
