/**
 *      IDEA : Really Good Use of DSU in this. Since we want to count paths between same value nodes and 
 *             "All nodes between the starting node and the ending node have values less than or equal to the starting node"
 *             this should hint us at processing the subgraph with values <= currMax.
 * 
 *             Here is the IDEA -> 
 *             
 *             1) Create a TreeMap mapping val-> list of nodes with value=val
 *             2) Create the adj list using edges
 *             3) Now, we will traverse the keys in sorted order(thats why we used TreeMap).
 *             4) So for current value `val`, we want to traverse on each node with this val.
 *             5) Now at this point, the graph we have built till now only has nodes values < `val`...
 *                We are using DSU to keep track of connected components. Now, for each node with value=`val`
 *                we will add union it with edges to nodes with value SMALLER OR EQUAL to `val`.
 *             6) Now at this point, the graph we have built now only has node values <= `val`.
 *                THIS ENSURES THAT ANY PATH WE WILL BE CONSIDERING BETWEEN 2 `val` VALUED NODES WILL NOT HAVE A VALUE LARGER THAN `val`
 *             7) So currently we will be having one or more trees in our graph. Here are some common facts we already know:
 *                  1) Between any 2 nodes in a tree, there is exactly one path.
 *                  2) In our tree, a path between 2 `val` valued nodes will have all nodes in the path with value <= `val`
 *             8) So the problem is simply to calculate the nC2 among val valued nodes of one component. And we sum it up for all the componenets
 *             9) To solve the above, create a mapping leader -> cnt of nodes that have value=val. Then, for each value in the map,
 *                add nC2 to the answer as we are consider paths between each 2 nodes with value=val
 *             10) Finally we return answer + vals.length(self loop path  : node to itself) 
 * 
 * 
 */

public class Number_of_Good_Paths {
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
            if(parent[u] == -1)
                return u;
            return parent[u] = find(parent[u]);
        }
        public void union(int a, int b)
        {
            int s1 = find(a), s2 = find(b);
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
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        DSU d = new DSU((int)1e5+1);
        TreeMap<Integer, List<Integer>> nodeList = new TreeMap<>();
        for(int i = 0; i<vals.length; i++)
            nodeList.computeIfAbsent(vals[i], k-> new ArrayList<>()).add(i);
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int edge[] : edges)
        {
            map.computeIfAbsent(edge[0], k-> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k-> new HashSet<>()).add(edge[0]);
        }
        int ans = 0;
        for(int key : nodeList.keySet())
        {
            List<Integer> nodes = nodeList.get(key);

            for(int node : nodes)
                for(int to : map.getOrDefault(node,new HashSet<>()))
                    if(vals[to] <= vals[node])
                        d.union(node, to);
            
            Map<Integer, Integer> compCnt = new HashMap<>();
            for(int node : nodes)
            {
                int leader = d.find(node);
                compCnt.put(leader, compCnt.getOrDefault(leader, 0)+1);
            }
            for(int val : compCnt.values())
                ans+=val*(val-1)/2;
        }
        return ans + vals.length;
    }
}
