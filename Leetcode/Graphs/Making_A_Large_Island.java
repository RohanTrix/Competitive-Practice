package Leetcode.Graphs;

/*
    IDEA : We basically want to try to convert each 0 in the matrix...and track the max component size
           that can be formed by doing this.
           First we build connected components using DSU. We can do this for 2D matrix using the following:
           
                        n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

           After building the DSU, we traverse of each cell. For each cell which is a 0,
           we calculate total of sizes of each neighbour's components. We MUST maintain a hashset to
           not double count 2 of the neighbour's sets which are basically the same set.
           Meaning that if the above cell has a component leader x1...and left cell also has a leader
           x1...then we should only count this once.

           Also we add 1 becuase we are changing exactly 1 zero.
           We take the max of all such "changed component size"



*/



public class Making_A_Large_Island {
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
            if(parent[u] == -1)
                return u;
            return parent[u] = find(parent[u]);
        }
        public void union(int u, int v)
        {
            int s1 = find(u);
            int s2 = find(v);
            if(s1== s2) return;
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
        }
    }
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        DSU d = new DSU(m*n);
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,1,-1};
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                int u = i*n+j;
                if(grid[i][j] == 0) continue;
                for(int p = 0; p<4; p++)
                {
                    int nx = (i+dr[p]), ny = (j+dc[p]);
                    int v = nx*n+ny;
                    if(nx<0 || nx>=m || ny<0 || ny>=n || grid[nx][ny] == 0)
                        continue;
                    d.union(u,v);
                    // System.out.println("Unioned : "+u+" "+v);
                }
            }
        }
        int maxi = 1;
        Set<Integer> hs = new HashSet<>();
        for(int num : d.rank) maxi = Math.max(maxi, num);
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1) continue;

                int u = i*n+j;
                int cnt = 0;
                for(int p = 0; p<4; p++)
                {
                    int nx = (i+dr[p]), ny = (j+dc[p]);
                    int v = nx*n+ny;
                    if(nx<0 || nx>=m || ny<0 || ny>=n || grid[nx][ny] == 0 || hs.contains(d.find(v)))
                        continue;
                    int leader = d.find(v);
                    hs.add(leader);
                    // System.out.print(d.rank[leader] + "\t");
                    cnt+=d.rank[leader];
                }
                maxi = Math.max(maxi, cnt+1);
                hs.clear();
                // System.out.println(hs);
            }
        }
        return maxi;
    }
}
