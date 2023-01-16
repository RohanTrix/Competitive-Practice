import java.util.Arrays;

public class Lexicographically_Smallest_Equivalent_String
{
    // Solved on binarysearch.com
    // Idea is to union lexicographically smaller to lexicographically larger. Here, we do not use rank..and instead use
    // char's lexicographical rank. Finally...we form the new string by replacing with leader of set(which is going to be lexicographically smallest)
    class DSU
    {
        int parent[];
        public DSU()
        {
            parent = new int[26];
            Arrays.fill(parent, -1);
        }
        public int find(int u)
        {
            if(parent[u] == -1)
                return u;
            return parent[u] = find(parent[u]);
        }
        public void union(int a, int b)
        {
            int s1 = find(a);
            int s2 = find(b);
            if(s1!=s2)
            {
                if(s1<s2)
                    parent[s2] = s1;
                else
                    parent[s1] = s2;
            }
        }
    }
    public String solve(String a, String b, String target) {
        int n = a.length();
        DSU d = new DSU();
        for(int i = 0; i<n; i++)
        {
            d.union(a.charAt(i)-'a', b.charAt(i)-'a');
        }
        char ans[] = new char[target.length()];
        n = target.length();
        for(int i = 0;i<n; i++)
        {
            ans[i] = (char)(d.find(target.charAt(i)-'a')+'a');
        }
        return new String(ans);
    }
}