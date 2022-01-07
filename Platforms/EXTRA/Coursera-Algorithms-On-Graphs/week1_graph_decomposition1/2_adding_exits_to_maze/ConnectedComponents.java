import java.util.*;
public class ConnectedComponents {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    //System.out.println("Enter the number of edges: ");
    int n = sc.nextInt();
    int m = sc.nextInt();
    ConnectedComponents g = new ConnectedComponents();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    int c=0;
    for(int i : g.edges.keySet())
    {
        if(!visited.contains(i)){
            g.dfs(i);
            c++;
    }
    }
    System.out.println(c);
    sc.close();
    
    
  }
  void dfs(int v)
  {
    if(visited.contains(v))
      return;
    visited.add(v);
    for(int u : edges.get(v))
    {
      dfs(u);
    }
  }
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<Integer>());
    }
  }
  public void removeNode(int u) {
    if (!edges.containsKey(u)) {
      return;
    }
    for (int v : edges.get(u)) {
      edges.get(v).remove(u);
    }
    edges.remove(u);
  }
  public void addEdge(int u, int v) {
    //addNode(u);
    //addNode(v);
    edges.get(u).add(v);
    edges.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
    edges.get(v).remove(u);
  }
}