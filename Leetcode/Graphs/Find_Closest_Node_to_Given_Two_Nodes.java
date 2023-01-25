/**
 *      IDEA : There can be only 1 path going out from a node since node can have atmost 1 edge.
 *             So we can basically get a unique DFS starting from a node. We use DFS to mark the inTime
 *             at every node. Now, we will call the dfs for the 2 nodes, node1 and node2. Finally 
 *             we want to take the first node where the MAX(dist1, dist2) is MINIMUM. 
 * 
 */
public class Find_Closest_Node_to_Given_Two_Nodes {
    int edges[];
    public void dfs(int u, int time, Integer dist[]) {
        if(dist[u] != null)
            return;
        dist[u] = time;
        if(edges[u] == -1) return;
        dfs(edges[u], time+1, dist);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        this.edges = edges;
        Integer dist1[] = new Integer[n], dist2[] = new Integer[n];
        dfs(node1, 0, dist1);
        dfs(node2, 0, dist2);
        int mini = Integer.MAX_VALUE/2, minInd = -1;
        for(int i = 0; i<n; i++) {
            if(dist1[i]== null || dist2[i] == null) continue;
            if(mini>Math.max(dist1[i], dist2[i])) {
                mini = Math.max(dist1[i], dist2[i]);
                minInd = i;
            }
        }
        return minInd;
    }
}