import java.util.*;
public class Redundant_Connection
{
    static class DSU
    {
        public int parent[];
        public int rank[];
        public DSU(int num)
        {
            parent = new int[num];
            rank = new int[num];
            Arrays.fill(rank, 1);
            Arrays.fill(parent, -1);
        }
        public int find(int i)
        {
            if( parent[i] == -1)return i;
            return parent[i] = find(parent[i]);
        }
        public boolean union(int a, int b)
        {
            int s1 = find(a);
            int s2 = find(b);
            if(s1==s2) return false;

            if(rank[s1]<rank[s2])
            {
                parent[s1] = s2;
                rank[s2] +=rank[s1];
            }
            else
            {
                parent[s2] = s1;
                rank[s1] += rank[s2];
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        
        DSU o = new DSU(edges.length);
        for(int i = 0; i<edges.length; i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            if(!o.union(a-1,b-1))return new int[]{a,b};
        }
        return new int[]{1,2};
    }
}