/**
 *      IDEA : Used DSU to check for cycles. Here the tricky part which clicked to me was the way to
 *             avoid cycle of size less than 4...for that we should only union cells which we will visit
 *             next and not the ones we have already visited while traversing.
 * 
 *             So we basically union in cell below and cell to the right if it is possible to.
 *             And for 2D cells we use (x*n+y) to encode it into a value for DSU
 */
public class Detect_Cycles_in_2D_Grid
{
    class DSU
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
        public boolean union(int a, int b)
        {
            int s1 = find(a);
            int s2 = find(b);
            if(s1 != s2)
            {
                if(rank[s1]>rank[s2])
                {
                    rank[s1]+=rank[s2];
                    parent[s2] = s1;
                }
                else
                {
                    rank[s2]+=rank[s1];
                    parent[s1] = s2;
                }
                return false;
            }
            return true;
        }
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dr[] = {1,0,1};
        DSU d = new DSU(m*n);
        boolean ans = false;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                int u = i*n+j;
                for(int p = 0; p<2;p++)
                {
                    int ni = i+dr[p], nj = j+dr[p+1];
                    if(Math.min(ni, nj)<0 || ni>=m || nj>=n) continue;
                    int v = ni*n+nj;
                    if(grid[i][j] == grid[ni][nj]) ans = ans || d.union(u,v); 
                }
            }
        }
        return ans;
    }
}