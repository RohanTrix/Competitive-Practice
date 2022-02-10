/*
        IDEA : Explained in OneNote
*/
public class Shortest_Path_with_Alternating_Colors
{
    HashMap<Integer, Set<Integer>> redg = new HashMap<>(); // Red Edges
    HashMap<Integer, Set<Integer>> blueg = new HashMap<>(); // Blue Edges
    public int[] shortestAlternatingPaths(int n, int[][] reds, int[][] blues) {
        
        for(int i = 0; i<reds.length; i++)
            addRedEdge(reds[i][0], reds[i][1]);
        for(int i = 0; i<blues.length; i++)
            addBlueEdge(blues[i][0], blues[i][1]);
        
        Queue<pair> queue = new ArrayDeque<>(); // Queue containing node and which edge they came from
        Set<pair> visited = new HashSet<>(); // Visited set containing node and which edge they came from
        queue.add(new pair(0,'R')); // We can imagine zero came from both a blue path and a red path
        queue.add(new pair(0,'B'));
        visited.add(new pair(0,'R'));
        visited.add(new pair(0,'B'));
        int fromRedDist[] = new int[n]; // ith element's distance when coming from a red edge
        int fromBlueDist[] = new int[n];// ith element's distance when coming from a blue edge
        Arrays.fill(fromRedDist, Integer.MAX_VALUE/2); fromRedDist[0] = 0;
        Arrays.fill(fromBlueDist, Integer.MAX_VALUE/2); fromBlueDist[0] = 0;
        while(!queue.isEmpty())
        {
            pair curr = queue.poll();
            
            if(curr.color == 'R')
            {
                for(int to : blueg.getOrDefault(curr.node, new HashSet<>()))
                {
                    pair next = new pair(to,'B');
                    if(visited.contains(next))
                        continue;
                    visited.add(next);
                    fromBlueDist[to] = fromRedDist[curr.node] + 1;
                    queue.add(next);
                }
            }
            else
            {
                for(int to : redg.getOrDefault(curr.node, new HashSet<>()))
                {
                    pair next = new pair(to,'R');
                    if(visited.contains(next))
                        continue;
                    visited.add(next);
                    fromRedDist[to] = fromBlueDist[curr.node] + 1;
                    queue.add(next);
                }
            }
            
        }
        int dist[] = new int[n]; // We want minimum of red and blue edge distances for each node...or unreachble
        for(int i = 0; i<n; i++)
        {
            dist[i] =  Math.min(fromRedDist[i], fromBlueDist[i]);
            dist[i] =  dist[i]==Integer.MAX_VALUE/2?-1:dist[i];
        }
        return dist;
        
    }
    void addRedNode(int u)
    {
        if(!redg.containsKey(u))
            redg.put(u, new HashSet<Integer>());
    }
    void addBlueNode(int u)
    {
        if(!blueg.containsKey(u))
            blueg.put(u, new HashSet<Integer>());
    }
    void addRedEdge(int u, int v)
    {
        addRedNode(u);
        addRedNode(v);
        redg.get(u).add(v);
    }
    void addBlueEdge(int u, int v)
    {
        addBlueNode(u);
        addBlueNode(v);
        blueg.get(u).add(v);
    }
    private class pair
    {
        int node;
        char color;
        public pair(int n, char c)
        {
            node = n;
            color = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof pair)) return false;
            pair that = (pair)o;
            return node == that.node && color == that.color;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(node, color);
        }
    }
}