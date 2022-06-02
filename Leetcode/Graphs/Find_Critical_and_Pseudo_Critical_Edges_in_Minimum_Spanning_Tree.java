/*
 * IDEA : Explained in OneNote
 *        Step 1) Form MST and get minCost
 *        Step 2) Iterate over all edges and do the following
 *                
 *                  -> Exclude curr edge, build a MST...if MST cost increase of decreases from minCost, then edge is critical
 *                  -> IF edge is NOT CRITICAL, then FORCEFULLY INCLUDE this edge, build a MST. If MST cost as minCost,
 *                     then this edge is pseudo-critical
 */

public class Find_Critical_and_Pseudo_Critical_Edges_in_Minimum_Spanning_Tree
{
    static class DSU
    {
        int parent[], rank[];
        public DSU(int n)
        {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        public int find(int u)
        {
            if(parent[u] == -1) return u;
            return parent[u] = find(parent[u]);
        }
        public boolean union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            if(s1!=s2)
            {
                if(rank[s1]>rank[s2])
                {
                    parent[s2] = s1;
                    rank[s1]+=rank[s2];
                }
                else
                {
                    parent[s1] = s2;
                    rank[s2]+=rank[s1];
                }
                return true;
            }
            return false;
        }
    }
    public int buildMST(int n, List<Edge> edges, Edge skip, Edge force)
    {
        // skip is either null or a edge to be skipped during MST formation
        // force is either null or an edge to be added first to the MST followed by rest of the MST formation.
        int cost = 0;
        DSU d = new DSU(n);
        Collections.sort(edges, (a,b) -> a.w - b.w);
        if(force!=null)
        {
            d.union(force.from, force.to);
            cost+=force.w;
        }
        for(Edge edge : edges)
        {
            if(edge.equals(skip)) continue;
            if(d.union(edge.from, edge.to))
                cost+=edge.w;
        }
        return cost;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edgeArr) 
    {
        List<Edge> edges = new ArrayList<>();
        Map<Edge, Integer> edgeIdx = new HashMap<>();
        int i = 0;
        for(int edge[] : edgeArr)
        {
            Edge curr = new Edge(edge[0], edge[1], edge[2]);
            edges.add(curr);
            edgeIdx.put(curr,i++);
        }
        
        List<Integer> critical = new ArrayList<>(), pseudo = new ArrayList<>();
        int minCost = buildMST(n, edges, null, null);
        System.out.println(minCost);
        for(int edge[] : edgeArr)
        {
            // edges.remove(new Edge(edge[0], edge[1], edge[2]));
            Edge curr = new Edge(edge[0], edge[1], edge[2]);
            int new_cost = buildMST(n, edges, curr, null);
            if(new_cost<minCost || new_cost>minCost)
                critical.add(edgeIdx.get(curr));
            else
            {
                new_cost = buildMST(n, edges, null, curr);
                if(new_cost == minCost)
                    pseudo.add(edgeIdx.get(curr));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical); ans.add(pseudo);
        return ans;
        
        
        
    }
    class Edge
    {
        int from, to, w;
        public Edge(int from, int to, int w)
        {
            this.from = from;
            this.to = to;
            this.w = w;
        }
        public boolean equals(Object e)
        {
            if(e == null) return false;
            Edge that = (Edge) e;
            return from == that.from && to == that.to && w == that.w;
        }
        public int hashCode()
        {
            return Objects.hash(from,to,w);
        }
    }
}