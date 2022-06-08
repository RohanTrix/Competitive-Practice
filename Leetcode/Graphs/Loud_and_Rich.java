/**
 *      IDEA : Sovled in One go :)
 *             Best way to solve such a problem is to draw a graph. I draw a graph with edges going from less rich-> more rich.
 *             The question then becomes finding a child node for which the quiet value is minimum.
 *             Also, this graph will be a directed tree - REFER IMG : https://ibb.co/PjYZ8P8
 * 
 *             Now, we can define dp[i] = A pair of minimum quietness value and node with that val that 
 *                                        i is a ancestor of.
 *             
 *             So when we first explore i, we explore its subtree completelty and finally we will have
 *             received from each of its neighbours, the best pair in their subtree. So accordingly we update
 *             ans for current node. Go thru code to understand more clearly
 */

public class Loud_and_Rich {
    pair dp[];
    int quiet[];
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    public pair dfs(int u) // returns [quietness, node]
    {
        if(dp[u]!=null) return dp[u];
        int mini = quiet[u], ans = u;
        
        for(int to : edges.get(u))
        {
            pair res = dfs(to);
            if(res.qval<mini)
            {
                mini = res.qval;
                ans = res.node;
            }
        }
        return dp[u] = new pair(mini, ans);
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        int n = quiet.length;
        dp = new pair[n];
        for(int i = 0; i<n; i++)
            edges.put(i, new HashSet<>());
        for(int edge[] : richer)
            edges.get(edge[1]).add(edge[0]);
        
        int ans[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            if(dp[i]==null)
                dfs(i);
            ans[i] = dp[i].node;
        }
        return ans;
    }
    class pair
    {
        int qval, node;
        public pair(int q, int node)
        {
            qval = q;
            this.node = node;
        }
    }
}
