//package Graphs;
import java.util.*;
@SuppressWarnings("rawtypes")
public class NegativeCycle {
  // Works on a DAG even with negative edge weights
  // Adjaceny List
  public Map<Integer, Set<pair>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  //Topological Ordering
  public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
  // Array storing which nodes come before ith node in shortest path from starting node
  public static int prev[];

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    //System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    //System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    NegativeCycle g = new NegativeCycle();
    for(int i =1; i<=n;i++)
      g.addNode(i);

    for(int i =0; i< m;i++)
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());
    //System.out.println("Enter the starting node:");
    int s = 1;

    //System.out.println("Shortest Path Array: \n");
    System.out.println(g.bellmanFord(n,s));
    //System.out.println(g.edges);
    sc.close();
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  int bellmanFord(int numNodes, int start)
  {
        double dist[] = new double[numNodes+1];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;

        // For each vertex, apply relaxation for all the edges
        for (int i = 0; i < numNodes - 1; i++)
            for (Integer node : edges.keySet())
                for (pair edge : edges.get(node))
                    if (dist[node] + edge.weight < dist[edge.neighbour])

                        dist[edge.neighbour] = dist[node] + edge.weight;
        
    // Run algorithm a second time to detect which nodes are part
    // of a negative cycle. A negative cycle has occurred if we
    // can find a better path beyond the optimal solution.
    for (Integer node : edges.keySet())
        for (pair edge : edges.get(node))
            if (dist[node] + edge.weight < dist[edge.neighbour]) 
                return 1;
    
    return 0;

  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class pair<neighbour,weight> implements Comparable < pair<neighbour,weight> >
    {
      int neighbour;
      long weight;
      pair(int i, long j) {
          neighbour = i;
          weight = j;
      }
      public int compareTo(pair p) {
          return Long.compare(this.weight,p.weight);
          
      }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<pair>());
    }
  }
  public void addEdge(int u, int v, long w) {
    edges.get(u).add(new pair(v,w));
    //edges.get(v).add(u);
  }
}