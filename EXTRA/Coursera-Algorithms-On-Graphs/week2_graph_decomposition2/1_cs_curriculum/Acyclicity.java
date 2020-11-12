import java.util.*;
public class Acyclicity {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static Set<Integer> explored = new HashSet<Integer>();
  public static boolean cycle = false;
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    //System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    //System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Acyclicity g = new Acyclicity();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    for(int i : g.edges.keySet())
    {
        if(!explored.contains(i))
            g.dfs(i);

    }
    if(cycle)
    System.out.print(1);
    else
    System.out.print(0);
    sc.close();
  }
  
  void dfs(int v)
  {
    if(visited.contains(v))
      {
        cycle = true;
        return;
      }
    visited.add(v);
    for(int u : edges.get(v))
    {
      if (!explored.contains(u))
      dfs(u);
    }
    visited.remove(v);
    explored.add(v);
    
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
    //edges.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
    //edges.get(v).remove(u);
  }
}