/**
 *      IDEA : Dijkstra is used but the Node for the PQ here is not just the node going to and the edge, but also the available stops.
 *             We have to store the distance for each Node. Here the distance should be recorded based on 2 parameters...node and k.
 *             This is because there can be different paths to the same node and one path may not be best distance wise but may be better
 *             in a way that it leaves more stops.
 */

public class Cheapest_Flights_Within_K_Stops {
    Map<Integer, List<Node>> edges = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        for(int i = 0; i<n; i++) edges.put(i, new ArrayList<>());
        for(int flight[] : flights)
        {
            edges.get(flight[0]).add(new Node(flight[1],-1, flight[2]));
        }
        
        int dist[][] = new int[101][k+5];
        for(int d[] : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][k+1] = 0;
        pq.offer(new Node(src, k+1, 0));
        while(!pq.isEmpty())
        {
            // System.out.println(pq);
            Node curr = pq.poll();
            visited.add(curr);
            if( curr.node == dst) return dist[dst][curr.k];
            if( dist[curr.node][curr.k] < curr.cost || curr.k == 0)
                continue;
            for(Node to : edges.get(curr.node))
            {
                if(visited.contains(to.node)) continue;
                int newDist = dist[curr.node][curr.k] + to.cost;
                if(dist[to.node][curr.k-1] > newDist)
                {
                    dist[to.node][curr.k-1] = newDist;
                    pq.offer(new Node(to.node, curr.k-1, newDist));
                }
            }
        }
        return -1;
    }
    class Node
    {
        int node, k, cost;
        public Node(int node, int k, int cost)
        {
            this.node = node;
            this.k = k;
            this.cost = cost;
        }
        public boolean equals(Object o)
        {
            Node p = (Node)o;
            return  node == p.node && k == p.k && cost == p.cost;
        }
        public int hashCode()
        {
            return Objects.hash(node, k, cost);
        }
    }
}
