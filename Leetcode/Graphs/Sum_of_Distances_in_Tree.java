// Explained in OneNote : Tree DP section
public class Sum_of_Distances_in_Tree {
    int count[], res[];
    public Map<Integer, Set<Integer>> edges = new HashMap<>();
    public int get_tot_sum(int u, int par)
    {
        count[u] = 1;
        int sum = 0;
        for(int to : edges.get(u))
        {
            if(to == par) continue;
            sum+= get_tot_sum(to, u) + count[to];
            count[u] += count[to];
        }
        return sum;
    }
    
    public void computeAns(int u, int par, int prevAns, int n)
    {
        res[u] = prevAns - count[u] + (n - count[u]);
        
        for(int to : edges.get(u))
            if(to!=par)
            computeAns(to, u, res[u], n);

    }
    public int[] sumOfDistancesInTree(int n, int[][] eds) {
        count = new int[n];
        res = new int[n];
        if(n==1) return res;
        for(int edge[] : eds)
            addEdge(edge[0], edge[1]);
        
        int tot_sum_from_root = get_tot_sum(0, -1);
        res[0] = tot_sum_from_root;
        for(int to : edges.get(0))
            computeAns(to, 0, res[0], n);
        return res;
    }
    void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new HashSet<>());
    }
    void addEdge(int u, int v)
    {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}
