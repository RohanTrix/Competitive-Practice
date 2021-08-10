package Leetcode.Graphs;
import java.util.*;
public class Critical_Connections_in_a_Network {
    /* Finding a Bridge in a Graph --- Check Java implementation in Own Repo */
    // Also Refer: https://youtu.be/RYaakWv5m6o
    Map<Integer, Set<Integer>> edges = new TreeMap<>();
    HashSet<Integer> visited;
    List<List<Integer>> bridges;
    int time;
    int[] lowlink, ids;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(List<Integer> con : connections)
        {
            addEdge(con.get(0), con.get(1));
        }
        
        System.out.println(edges);
        visited = new HashSet<>();
        
        bridges = new ArrayList<>();
        time = 1;
        lowlink = new int[n+1];
        ids = new int[n+1];
        Arrays.fill(ids, -1);
        

        for (int u = 0; u <n; u++)
        {
          if (!visited.contains(u))
          {
              dfs(u, -1);
          }
        }
        return bridges;
    }
    void dfs(int at, int parent) {
        lowlink[at] = ids[at] = time++;
        visited.add(at);
        
        for (int to : edges.get(at)) 
        {
            if(to==parent) continue;

            if (visited.contains(to)) 
                lowlink[at] = Math.min(lowlink[at], ids[to]);

            else
            {
                dfs(to, at);
                lowlink[at] = Math.min(lowlink[at], lowlink[to]);
                
                if(lowlink[to]>ids[at])
                {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(at);tmp.add(to);
                    bridges.add(tmp);
                    
                }
                    
            }
        }
    }
  
    
    ///////////////////////////////////// Adjacency List Maker////////////////////////////////////////////////
    public void addNode(int u) {
        if (!edges.containsKey(u)) {
        edges.put(u, new TreeSet<>());
        }
    }
    public void addEdge(int u, int v) {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}
