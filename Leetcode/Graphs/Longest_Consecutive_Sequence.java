import java.util.stream.*;

// IDEA : DSU should be used because the order of a chain(consecutive elements in the array) doesnt matter...only how the elements are
//        connected matter.
public class Longest_Consecutive_Sequence {
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
            if(s1 != s2)
            {
                if(rank[s1] > rank[s2])
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
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        DSU d = new DSU(nums.length);
        Map<Integer, Integer> val_to_idx = new HashMap<>();
        for(int i = 0; i<nums.length; i++)
        {
            if(val_to_idx.containsKey(nums[i]))
                continue;
            
            if(val_to_idx.containsKey(nums[i] + 1))
                d.union(i, val_to_idx.get(nums[i] + 1));
            
            if(val_to_idx.containsKey(nums[i] - 1))
                d.union(i, val_to_idx.get(nums[i] - 1));
            
            val_to_idx.put(nums[i], i);
        }
        return IntStream.of(d.rank).max().getAsInt();
    }
}
