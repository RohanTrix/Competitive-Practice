import java.util.*;
class Minimum_Height_Trees
{
    /* The problem is basically finding the center(s) of the tree.
    
       Idea : The center of the tree is are the middle vertex/vertices
              of the longest path in the tree. If we root the tree at center, 
              the lonegest path in the tree will be broken into 
              half and hence, this is the best node to minimize the height of the tree
    
    */
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    public List<Integer> findCenter()
    {
        int n = edges.size();
        int indeg[] = new int[n];
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            indeg[i] = edges.get(i).size(); // Setting InDegree
            if(indeg[i] < 2) // Single Node or Leaf Node
            {
                leaves.add(i);
                indeg[i] = 0;
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
                    indeg[to]-=1;
                    if(indeg[to]==1)
                        new_leaves.add(to);
                }
                // indeg[leaf] = 0; Line no necessary
            }
            count+=new_leaves.size();
            leaves = new ArrayList<>(new_leaves);
        }
        return leaves;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        for(int i =0; i<n; i++) addNode(i);
        
        for(int i = 0; i<edges.length; i++)
            addEdge(edges[i][0], edges[i][1]);
        return findCenter();

    }
    ////////////////////////////////// ADJ MAKER ///////////////
    public void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new TreeSet<>());
    }
    public void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}