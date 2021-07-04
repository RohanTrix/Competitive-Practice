package Leetcode.Graphs;

import java.util.*;
class All_Paths_From_Source_to_Target {
    HashSet<Integer> hs = new HashSet<Integer>();
    List<List<Integer>> ans = new ArrayList<>();
    public void DFS(int graph[][], int node, ArrayList<Integer> curr)
    {
        if(hs.contains(node))return;
        
        if(node==graph.length-1)
        {
            curr.add(graph.length-1);
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        hs.add(node);
        curr.add(node);
        for(int i : graph[node])
        {
            ArrayList<Integer> a = new ArrayList<Integer>(curr);
            DFS(graph,i, a);
        }
        hs.remove(node);
        
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        DFS(graph, 0, new ArrayList<Integer>());
        return ans;
    }
}
