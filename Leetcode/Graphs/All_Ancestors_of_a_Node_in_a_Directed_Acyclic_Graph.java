/*
    IDEA : Similar to Kahn's Algorithm logic or Tree Center finding logic
           We take the leaf nodes to a leaves list. Then we put the children of these nodes,
           and if their indegree becomes 0 after removing the degree contributed by leaf nodes,
           then they get added to the new leaves list. 
           Now, Whenever we are adding the current node as a ancestors of its child,
           we also add all the ancestors of the current node to the child node's ancestors, thus
           acheiving kind of DP.

           Also, instead of maintaining a list of ancestors I am adding them to a TreeSet so that thye occur
           in sorted order.
           
*/

public class All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph {
    public Map<Integer, Set<Integer>> edges = new HashMap<>();
    int indeg[];
    public List<List<Integer>> getAncestors(int n, int[][] eds) {
        indeg = new int[n];
        for(int i = 0; i<n; i++) addNode(i);
        for(int edge[] : eds) addEdge(edge[0], edge[1]);
        
        List<List<Integer>> res = new ArrayList<>();
        List<Set<Integer>> ances = new ArrayList<>();
        for(int i = 0; i<n; i++)
            ances.add(new TreeSet<>());
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            if(indeg[i] == 0) // Leaf Node
            {
                leaves.add(i);
            }
        }
        
        int count = leaves.size();
        while(count<n)
        {
            ArrayList<Integer> new_leaves = new ArrayList<>();
            for(int leaf : leaves)
            {
                for(int to : edges.get(leaf))
                {
                    ances.get(to).add(leaf);
                    ances.get(to).addAll(ances.get(leaf));
                    indeg[to]-=1;
                    if(indeg[to]==0)
                        new_leaves.add(to);
                }
            }
            count+=new_leaves.size();
            leaves = new ArrayList<>(new_leaves);
        }
        
        for(int i = 0; i<n; i++)
        {
            res.add(new ArrayList<>(ances.get(i)));
        }
        return res;
    }
    public void addNode(int u)
    {
        edges.put(u, new HashSet<>());
        
    }
    public void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        indeg[v]++;
    }
}
