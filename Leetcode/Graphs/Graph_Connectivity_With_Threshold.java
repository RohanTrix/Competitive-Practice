/*      Idea:
            Clearly the problem is a DSU problem as we need to tell whether 2 nodes are connected or not.
            However, logically one would think to take each pair of nodes, find their GCD and check if
            it is above the threshold or not. That would take O(n^2*log(n)). This will TLE

            Hence we use Seive technique. In seive, we take a prime number and mark all its multiples
            as non prime. Instead of that, here we take a prime number and union all its multiples to it.
            One tricky thing to note is that we should start seiving from threshold and thus 
            also avoid the i*i optimization in the inner loop. By starting from threshold + 1, 
            we will be able to efficiently solve the problem in O(nloglogn).
            A base case of threshold=0 needs to be checked.

*/

public class Graph_Connectivity_With_Threshold {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        // All connected in case of threshold=0
        if (threshold == 0) {
            for (int[] q : queries)
                res.add(true);
            return res;
        }

        // Create a DSU of nodes 1..n
        DSU d = new DSU(n + 1);

        // Seiving to union the nodes
        for (int i = threshold + 1; i <= n; i++) {
            // If i is a prime number, it is its own set leader
            if (d.find(i) == i) {
                for (int j = i * 2; j <= n; j += i) { // Iterating from 2nd multiple of i
                    d.union(i, j); // Union to make connected
                }
            }
        }
        // For each query, check if they are in same set or not
        for (int q[] : queries) {
            res.add(d.find(q[0]) == d.find(q[1]) ? true : false);
        }
        return res;

    }

    static class DSU {
        int parent[];
        int rank[];

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }

        public int find(int u) {
            if (parent[u] == -1)
                return u;
            return parent[u] = find(parent[u]);
        }

        public void union(int u, int v) {
            int s1 = find(u);
            int s2 = find(v);

            if (s1 != s2) {
                if (rank[s1] < rank[s2]) {
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                } else {
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }
            }
        }
    }
}