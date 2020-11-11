import java.util.*;
public class Reachability {
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
    Reachability g = new Reachability();
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    int x = sc.nextInt();
    int y = sc.nextInt();

    if(!g.edges.keySet().contains(x))
    System.out.println(0);
    else{
    g.dfs(x);
    if(visited.contains(y))
    System.out.println(1);
    else
    System.out.println(0);
  }
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
    addNode(u);
    addNode(v);
    edges.get(u).add(v);
    edges.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
    edges.get(v).remove(u);
  }
}