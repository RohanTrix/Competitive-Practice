/*
    IDEA : We can precompute the 2 character frequencies (one at odd idxs only and other at even idxs).
           for each String word[i]. This is stored in oddeven[][][].

           Finally, in O(26*n2), we can match the odd and even idxs char frequencies for each pair of strings.
           
           If they are same, we can put them in same group using DSU. Finally, count -1 in parent array
           to get count of grps.

*/
public class Groups_of_Special-Equivalent_Strings {
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
    public int numSpecialEquivGroups(String[] words) {
        int n = words.length;
        int wordLen = words[0].length();
        int oddeven[][][] = new int[n][2][26];
        DSU d = new DSU(n);
        for(int i = 0; i<n; i++)
        {
            String word = words[i];
            for(int p = 0; p<wordLen; p+=2)
                oddeven[i][0][word.charAt(p)-'a']++;
            for(int p = 1; p<wordLen; p+=2)
                oddeven[i][1][word.charAt(p)-'a']++;
        }
        
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                boolean ans = true;
                for(int p = 0; p<26; p++)
                {
                    ans = ans && (oddeven[i][0][p] == oddeven[j][0][p]) && (oddeven[i][1][p] == oddeven[j][1][p]);
                }
                if(ans) d.union(i,j);
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++) cnt+=(d.parent[i] == -1)?1:0;
        return cnt;
    }
}
