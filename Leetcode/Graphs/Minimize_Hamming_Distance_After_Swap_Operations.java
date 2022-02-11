/*
    IDEA : Explained in OneNote
*/

public class Minimize_Hamming_Distance_After_Swap_Operations {
    static class DSU
    {
        int parent[];
        int rank[];
        public DSU(int maxi)
        {
            parent = new int[maxi];
            rank = new int[maxi];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        public int find(int u)
        {
            if(parent[u] == -1) 
                return u;
            return parent[u] = find(parent[u]);
        }
        public boolean checkSameSet(int u, int v)
        {
            return find(u) ==  find(v);
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
                    rank[s1]+=rank[s2];
                }
                else
                {
                    parent[s1] = s2;
                    rank[s2]+=rank[s1];
                }
            }
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        // Leader -> Nodes in component as a FreqMap
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        
        DSU d = new DSU(source.length);
        for(int allow[] : allowedSwaps)
            d.union(allow[0], allow[1]);
        int cnt = 0;
        
        for(int i = 0; i<source.length; i++)
        {
            int leader = d.find(i);
            if(!map.containsKey(leader))
                map.put(leader, new HashMap<>());
            
            HashMap<Integer, Integer> freqOfCurrComponent = map.get(leader);
            freqOfCurrComponent.put(source[i], freqOfCurrComponent.getOrDefault(source[i], 0) +1);
            if(freqOfCurrComponent.get(source[i]) == 0) freqOfCurrComponent.remove(source[i]);
            
            freqOfCurrComponent.put(target[i], freqOfCurrComponent.getOrDefault(target[i], 0) -1);
            if(freqOfCurrComponent.get(target[i]) == 0) freqOfCurrComponent.remove(target[i]);
        }
        for(int leader : map.keySet())
        {
            HashMap<Integer, Integer> freqOfCurrComponent = map.get(leader);
            int sum = 0;
            for(int val: freqOfCurrComponent.keySet())
                sum+=Math.abs(freqOfCurrComponent.get(val));
            cnt+=(sum/2);
        }
        return cnt;
    }
}
