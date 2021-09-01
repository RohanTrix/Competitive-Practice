import java.util.*;

/* IDEA:
        Since the problem is about finding the shortest path from a given node, 
        we immediatly think of Djikstra. However, since we have to also find number of ways here,
        we need to tweak Djisktra a bit to handle the case when 
        currNode's distance + edge's weight ==  Best Distance found till now to neighnour node.
        
        In this case, we need to update our number of ways

*/
// Also refer: https://youtu.be/1JCXqupyLoQ

public class Number_of_Ways_to_Arrive_at_Destination{
    static class pair
    {
        int to;long time;
        public pair(int n, long w)
        {
            to = n;
            time = w;
        }
    }
    public Map<Integer,Set<pair>> edges = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();
    public long ways[];
    public int countPaths(int n, int[][] roads) {
        long mod = 1000000007L;
        ways = new long[n]; // Stores number of ways to reach ith node
        long time[] = new long[n]; // Smallest time taken to reach ith node
        Arrays.fill(time,Long.MAX_VALUE/2);
        Arrays.fill(ways,0);
        ways[0] = 1; // Way to reach starting node is 1
        time[0] = 0;
        
        /////////////////////// Adj List creation : START //////////////////////////////////////////
        for(int i =0; i<n; i++)addNode(i);
        for(int i =0; i<roads.length; i++)
            addEdge(roads[i][0],roads[i][1], roads[i][2]);
        
        /////////////////////// Adj List creation : END //////////////////////////////////////////
        
        /// Djisktra Starts
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time,b.time));
        pq.add(new pair(0,0)); //Adding starting node
        
        while(!pq.isEmpty())
        {
            pair curr = pq.poll();
            visited.add(curr.to);
            if( time[curr.to] < curr.time) // Curr path's time is more than already found time.
                continue;
            
            for( pair edge : edges.get(curr.to))
            {
                if(visited.contains(edge.to))continue; // If neighbour is already visited, means it is
                                                       // full explored
                
                long newTime = time[curr.to] + edge.time; // time to reach nieghbour from current node
                
                if( newTime < time[edge.to])   //  If we find a strictly better path to neighbour
                {
                    ways[edge.to] = ways[curr.to]; // Ways to reach neighbour = Ways to reach current Node
                    time[edge.to] = newTime; // Update time
                    pq.add(new pair(edge.to, newTime));
                }
                else if(newTime == time[edge.to]) // If we found another path with a same time taken
                {
                    ways[edge.to] = (ways[edge.to]+ ways[curr.to])%mod;

                    // Ways to reach neighbour += ways to reach current node
                }
                
            }
            if(curr.to==n-1) return (int)ways[n-1]; // Early Exit --Not necessary tho
        }
        
        return (int)ways[n-1];
        
    }
    public void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new HashSet<pair>());
    }
    public void addEdge(int u, int v, long w)
    {
        
        edges.get(u).add(new pair(v,w));
        edges.get(v).add(new pair(u,w));
        
    }
}