public class Network_Delay_Time {

    // Implement Dijkstra and get the longest time taken
    public Map<Integer, Set<pair>> edges = new HashMap<>();
    boolean visited[];
    int prev[];
    long LONGMAX = Long.MAX_VALUE / 2;

    ///////////////////////////////////////////////////////////
    public int networkDelayTime(int[][] times, int n, int k) {

        for (int i = 1; i <= n; i++)
            addNode(i);
        for (int a[] : times)
            addEdge(a[0], a[1], a[2]);
        long dist[] = dijkstra_lazy(n, k);
        // System.out.println(Arrays.toString(dist));
        long maxi = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == LONGMAX)
                return -1;
            maxi = Math.max(dist[i], maxi);
        }
        return (int) maxi;

    }

    long[] dijkstra_lazy(int numNodes, int start) {
        // prev = new int[numNodes+1];
        // Arrays.fill(prev,-1);
        visited = new boolean[numNodes + 1];
        long dist[] = new long[numNodes + 1];
        Arrays.fill(dist, Long.MAX_VALUE / 2);

        long newDist = 0L;
        dist[start] = (long) 0;

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(start, 0));
        while (pq.size() != 0) {
            pair currNode = pq.poll();
            visited[currNode.neighbour] = true;

            if (dist[currNode.neighbour] < currNode.weight)
                continue;

            for (pair to : edges.get(currNode.neighbour)) {
                if (visited[to.neighbour])
                    continue;

                newDist = dist[currNode.neighbour] + to.weight;

                if (newDist < dist[to.neighbour]) {
                    // prev[to.neighbour] = currNode.neighbour;
                    dist[to.neighbour] = newDist;
                    pq.offer(new pair(to.neighbour, newDist));
                }
            }
        }
        return dist;
    }

    public void addNode(int u) {
        if (!edges.containsKey(u)) {
            edges.put(u, new HashSet<pair>());
        }
    }

    public void addEdge(int u, int v, long w) {
        edges.get(u).add(new pair(v, w));
        // edges.get(v).add(u);
    }

    static class pair implements Comparable<pair> {
        int neighbour;
        long weight;

        pair(int i, long j) {
            neighbour = i;
            weight = j;
        }

        public int compareTo(pair p) {
            return Long.compare(this.weight, p.weight);

        }
    }
}
