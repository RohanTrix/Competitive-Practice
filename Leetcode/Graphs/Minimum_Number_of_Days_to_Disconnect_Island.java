public class Minimum_Number_of_Days_to_Disconnect_Island {
    // REFER Alex Wice Interview Weekly 12
    // Problem more of case analysis...ans will atmost be 2
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
        public void union(int a, int b)
        {
            int s1 = find(a);
            int s2 = find(b);
            if(s1!=s2)
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
            }
        }
    }
    public int encode(int x, int y, int n)
    {
        return x*n+y;
    }
    public int cntComp(int grid[][])
    {
        int m = grid.length, n = grid[0].length;
        DSU d = new DSU(m*n);
        int dr[] = {1,0,-1,0,1};
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    for(int p = 0; p<4; p++)
                    {
                        int ni = i+dr[p], nj = j+dr[p+1];
                        if(Math.min(ni,nj)<0 || ni>=m || nj>=n || grid[ni][nj] == 0) continue;
                        int v1 = encode(i,j,n), v2  = encode(ni, nj, n);
                        d.union(v1, v2);
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(grid[i][j]==1 && d.find(encode(i,j,n)) == encode(i,j,n))
                    cnt++;
        return cnt;
    }
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = cntComp(grid);
        if(cnt == 0 || cnt>=2) return 0;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
            {
                int org = grid[i][j];
                grid[i][j] = 0;
                cnt = cntComp(grid);
                if(cnt == 0 || cnt>=2) return 1;
                grid[i][j] = org;
            }
        return 2;
    }
}
