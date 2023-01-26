/**
 *      IDEA : Dijkstra is used but the Node for the PQ here is not just the node going to and the edge, but also the available stops.
 *             We have to store the distance for each Node. Here the distance should be recorded based on 2 parameters...node and k.
 *             This is because there can be different paths to the same node and one path may not be best distance wise but may be better
 *             in a way that it leaves more stops.
 */
import java.util.*;
public class Cheapest_Flights_Within_K_Stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int f[] : flights){
            map.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new Node(f[1], f[2], -1));
        }
        k++;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost() - b.cost());
        pq.offer(new Node(src, 0, k));
        Set<Node> visited = new HashSet<>();
        visited.add(new Node(src,0, k));
        int dist[][] = new int[101][k+1];
        for(int a[] : dist) Arrays.fill(a, Integer.MAX_VALUE);
        dist[src][k] = 0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            visited.add(curr);
            if(curr.node == dst)
                return dist[curr.node][curr.k];
            if( dist[curr.node][curr.k] < curr.cost || curr.k == 0 ) continue;

            for(Node to : map.getOrDefault(curr.node, new ArrayList<>())){
                if(visited.contains(to)) continue;
                int newDist = dist[curr.node][curr.k] + to.cost;
                if(dist[to.node][curr.k-1] <= newDist) continue;
                dist[to.node][curr.k-1] = newDist;
                Node nextNode = new Node(to.node, newDist, curr.k-1);
                pq.offer(nextNode);
            }
        }
        return -1;
    }
    public record Node(int node, int cost, int k) {}
}
