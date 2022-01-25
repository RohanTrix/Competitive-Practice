public class Number_of_Provinces
{
    // Simply find no. of connected components
    private class DSU
    {
        int parent[], rank[];
        public DSU(int n)
        {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        public int find(int u)
        {
            if(parent[u]==-1) return u;
            return parent[u] = find(parent[u]);
        }
        public void union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            
            if(s1!=s2)
            {
                if(rank[s1]>rank[s2])
                {
                    parent[s2] = s1;
                    rank[s1] += s2;
                }
                else
                {
                    parent[s1] = s2;
                    rank[s2]+=s1;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        DSU d = new DSU(n);
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
                if(isConnected[i][j]==1)
                    d.union(i,j);
        }
        int cnt = 0;
        for(int i = 0; i<n; i++) cnt+=(d.parent[i]==-1)?1:0;
        return cnt;
    }
}