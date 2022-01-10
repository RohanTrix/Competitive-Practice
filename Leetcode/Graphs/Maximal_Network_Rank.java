import java.util.*;
// Shown O(n^2) below

// O(n) solution is to find city with biggest number 
public class Maximal_Network_Rank {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        
        for(int i = 0 ; i<roads.length; i++)
            addEdge(roads[i][0], roads[i][1]);
        
        int maxi = 0;
        for(int i: edges.keySet())
        {
            int a = edges.get(i).size();
            for(int j: edges.keySet())
            {
                if(i==j) continue;
                int b = edges.get(j).size();
                
                int sum = a+b;
                if(edges.get(i).contains(j)) sum--;
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
    public void addNode(int u)
    {
        if(!edges.containsKey(u)) edges.put(u, new HashSet<>());
    }
    public void addEdge(int u, int v)
    {
        addNode(u); addNode(v);
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}