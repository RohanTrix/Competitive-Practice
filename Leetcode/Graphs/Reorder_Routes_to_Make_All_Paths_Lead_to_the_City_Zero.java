/**
 *      IDEA : We want to find if all nodes are reachable to zero. We want to check whether immediate neighbours of 0 can reach 0.
 *             If any of them cannot,we add our cost. Next, we will explore these neighbours.
 * 
 *             The problem is the graph is directed...so using this graph to do a BFS-lie approach to check reachability
 *             is not going to work. Instead, we create an undirected graph, to be able to traverse easily..and actually checking the
 *             direction of real edges in `edges` map
 */

public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    Map<Integer, Set<Integer>> dir_edges = new HashMap<>();

    public int minReorder(int n, int[][] connections) {
        int cnt = 0;
        for(int i = 0; i<n; i++)
        {
            edges.put(i, new HashSet<>());
            dir_edges.put(i, new HashSet<>());
        }
        for(int conn[] : connections)
        {
            dir_edges.get(conn[0]).add(conn[1]);
            edges.get(conn[0]).add(conn[1]);
            edges.get(conn[1]).add(conn[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int to : edges.get(curr))
            {
                if(visited.contains(to)) continue;
                if(!dir_edges.get(to).contains(curr))
                    cnt++;
                visited.add(to);
                q.offer(to);
            }
        }
        return cnt;
    }
}
