/**
 *      IDEA : To be Explained in One Note.
 */

public class Checking_Existence_of_Edge_Length_Limited_Paths {
    static class DSU 
    {
        public int parent[];
        public int rank[];
        public DSU(int num)
        {
            parent = new int[num];
            rank = new int[num];
            Arrays.fill(rank,1);
            Arrays.fill(parent,-1);
        }
        public int find( int i)
        {
            if(parent[i]== -1)
            {
                return i;
            }
            return parent[i] = find(parent[i]); // Path Compression
        }
        public boolean union(int a, int b)
        {
            int s1 = find(a);
            int s2 = find(b);
            if( s1!= s2)
            {
                if( rank[s1] < rank[s2] )
                {
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                }
                else
                {
                    parent[s2] = s1;
                    rank[s1] += rank[s2]; 
                }
                return true;
            }
            return false;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU d = new DSU(n);
        List<Edge> list = new ArrayList<>();
        for(int edge[] : edgeList)
            list.add(new Edge(edge[0], edge[1], edge[2]));
        
        boolean ans[] = new boolean[queries.length];
        for(int i = 0; i<queries.length; i++)
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        
        int i = 0;
        Arrays.sort(queries, (a,b) -> a[2] - b[2]);
        Collections.sort(list, (a,b) -> a.cost - b.cost);
        int maxi = Integer.MIN_VALUE;
        for(int k = 0; k<queries.length; k++)
        {
            int limit = queries[k][2];
            while(i<list.size() && list.get(i).cost<limit)
            {
                Edge edge = list.get(i++);
                int from = edge.from, to = edge.to, cost = edge.cost;
                if(d.find(from) != d.find(to))
                {
                    d.union(from, to);
                    maxi = Math.max(maxi, cost);
                }
            }
            int qu = queries[k][0], qv = queries[k][1];
            if(d.find(qu) == d.find(qv))
                ans[queries[k][3]] = maxi < limit;
        }
        return ans;
    }
    class Edge
    {
        int from, to, cost;
        public Edge(int from, int to, int cost)
        {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
