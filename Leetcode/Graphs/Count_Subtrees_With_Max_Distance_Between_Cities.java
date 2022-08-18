public class Count_Subtrees_With_Max_Distance_Between_Cities {
    /**
     *      IDEA : Since n <= 15, so we can iterate over all subset of edges. For each subset of edges, we build a graph.
     *             If the graph...if the graph is a single component(a tree), then we can find the diameter of this tree using
     *             2 DFS calls and increase the count for this diameter by 1 in the answer
     */
    int ans[];
    int maxNode = -1, maxDep = -1;
    Map<Integer, List<Integer>> graph;
    public void dfs1(int u, int par, int dep)
    {
        if(dep>maxDep)
        {
            maxDep = dep;
            maxNode = u;
        }
        for(int to : graph.get(u))
            if(to!=par)
                dfs1(to, u, dep+1);
    }
    public int dfs2(int u, int par)
    {
        int maxi = 0;
        for(int to : graph.get(u))
            if(to!=par)
                maxi = Math.max(maxi, dfs2(to, u));
        return maxi+1;
    }
    public void calcDiameter(int someNode, Map<Integer, List<Integer>> map)
    {
        this.graph = map;
        maxNode = -1; maxDep = -1;
        dfs1(someNode,-1, 0);
        ans[dfs2(maxNode, -1)-2]++;
    }
    public int compSize(int u, int par, Map<Integer, List<Integer>> map)
    {
        int res = 1;
        for(int to : map.get(u))
            if(to!=par)
                res+=compSize(to, u, map);
        return res;
    }
    public void buildGraph(int mask, int edges[][])
    {
        int n = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int someNode = -1;
        for(int i = 0;i<n; i++)
        {
            if((mask&(1<<i))!=0)
            {
                int u = edges[i][0], v = edges[i][1];
                someNode = u;
                map.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
                map.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
            }
        }
        if(compSize(someNode, -1, map) != map.keySet().size())
            return;
        calcDiameter(someNode, map);
    }
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        n--;
        ans = new int[n];
        // For each subset of edges, check if they make a single subtree
        for(int i = 1; i < (1<<n); i++)
            buildGraph(i, edges);
        return ans;
    }
}
