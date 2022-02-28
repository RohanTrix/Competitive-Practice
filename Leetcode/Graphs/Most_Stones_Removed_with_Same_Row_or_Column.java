import java.util.stream.*;
/*
    IDEA : DSU directly gives us the number of nodes in a connected component using its rank.
           Now, in each component, n-1 nodes will be removed if there are n nodes in a component.
*/
public class Most_Stones_Removed_with_Same_Row_or_Column
{
    static class DSU
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
            if(parent[u] == -1) return u;
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
                    rank[s1]+=rank[s2];
                    parent[s2]= s1;
                }
                else
                {
                    rank[s2]+=rank[s1];
                    parent[s1]= s2;
                }
            }
        }
    }
    public int removeStones(int[][] stones) {
        
        DSU d = new DSU(stones.length);
        for(int i = 0; i<stones.length; i++)
        {
            int x = stones[i][0], y = stones[i][1];
            for(int j = 0; j<i; j++)
            {
                int xx = stones[j][0], yy = stones[j][1];
                if(x == xx || y == yy) d.union(i,j);
            }
        }
        int cnt = 0;
        for(int i = 0; i<stones.length; i++)
        {
            if(d.parent[i] == -1)
                cnt+=d.rank[i]-1;
        }
        return cnt;
    }
}