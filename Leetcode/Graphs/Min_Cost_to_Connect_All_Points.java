/*
    IDEA : Connecting all points with minimum no. of edges which give minimum cost is a classic use
           case of finding MST in a graph. Here since we can connect any point with any other point,
           so initially we can assume our graph is made up of edges from every point to every other point.

           Now we just sort these edges based on the weight and while forming the MST, we just add the weight
           of the edge to the minimum final cost.
           Here we use Kruskal's MST algorithm. A better alternative would be Prim's since it is good for dense graphs
*/
public class Min_Cost_to_Connect_All_Points {
    class Solution {
    
        public int minCostConnectPoints(int[][] points) {
            List<Edge> edges = buildEdgeList(points);
            DSU dsu = new DSU(points.length);
            int minCost = 0;
            
            Collections.sort(edges);
            for(Edge curr : edges)
            {
                if(dsu.find(curr.node1) == dsu.find(curr.node2)) continue;
                dsu.union(curr.node1, curr.node2);
                minCost+=curr.dist;
            }
            return minCost;
        }
        public List<Edge> buildEdgeList(int[][] points)
        {
    
            List<Edge> edgelist = new ArrayList<>();
            for(int i = 0; i<points.length; i++)
            {
                for(int j = i+1; j<points.length; j++)
                {
                    Edge edge = new Edge(i,j, points[i][0], points[i][1], points[j][0], points[j][1]);
                    edgelist.add(edge);
                }
            }
            return edgelist;
        }
        // Edge stores the indices of the 2 points from points array and the Manhattan distance betweem them
        class Edge implements Comparable<Edge>
        {
            int node1, node2, dist;
            public Edge(int i, int j,int x1, int y1,int x2, int y2)
            {
                node1 = i; node2 = j;
                dist = Math.abs(x2-x1) + Math.abs(y2-y1);
            }
            public int compareTo(Edge p)
            {
                return Integer.compare(dist, p.dist);
            }
        }
        static class DSU
        {
            int parent[];
            int rank[];
            public DSU(int n)
            {
                parent = new int[n];
                rank = new int[n];
                Arrays.fill(parent, -1);
                Arrays.fill(rank, 1);
            }
            public int find(int u)
            {
                if(parent[u] == -1) return u;
                return parent[u] = find(parent[u]);
            }
            public void union(int u, int v)
            {
                int s1 = find(u);
                int s2 = find(v);
                
                if(s1!=s2)
                {
                    if(rank[s1]<rank[s2])
                    {
                        parent[s1] = s2;
                        rank[s2]+=rank[s1];
                    }
                    else
                    {
                        parent[s2] = s1;
                        rank[s1]+=rank[s2];
                    }
                }
            }
        }
    }
    
}
