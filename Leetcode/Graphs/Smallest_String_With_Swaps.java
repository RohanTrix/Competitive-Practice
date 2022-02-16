/*
    IDEA : LOGIC Similar to LC : Minimize Hamming Distance After Swap Operations

            The swappable elements form connected components among themselves.
            We can keep track of these components, sort them lexicographically and put
            back the sorted version on the indexes with which this component was formed.
*/
import java.util.*;
public class Smallest_String_With_Swaps
{
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char str[] = s.toCharArray();
        char smallestStr[] = new char[s.length()];
        DSU dsu = new DSU(str.length);
        
        for(int i = 0; i<pairs.size(); i++)
            dsu.union(pairs.get(i).get(0), pairs.get(i).get(1));
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++)
        {
            int leader = dsu.find(i);
            List<Integer> nodes = map.getOrDefault(leader, new ArrayList<>());
            nodes.add(i);
            map.put(leader, nodes);
        }
        for(int leader : map.keySet())
        {
            List<Integer> order = new ArrayList<>(map.get(leader));
            Collections.sort(order, (a,b) -> str[a] - str[b]);
            for(int i = 0; i<order.size(); i++)
                smallestStr[map.get(leader).get(i)] = str[order.get(i)];
        }
            
        return new String(smallestStr);
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
}