package Leetcode.Graphs;

import java.util.*;
class All_Paths_From_Source_to_Target {
    HashSet<Integer> hs = new HashSet<Integer>(); // Visited Set
    List<List<Integer>> ans = new ArrayList<>(); // Stores the final answer
    public void DFS(int graph[][], int node, ArrayList<Integer> curr)
    {
        if(hs.contains(node))return; // Return if node visited
        
        if(node==graph.length-1) // If this is the final node, add node to the                                    // curr list to final answer
        {
            curr.add(graph.length-1);
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        hs.add(node); // Visit the node, then start its dfs process
        curr.add(node); // Add current node to current list
        for(int i : graph[node]) // For each edge going out, call its dfs
        {
            ArrayList<Integer> a = new ArrayList<Integer>(curr);
            DFS(graph,i, a);
        }
        hs.remove(node); // IMP: Once a dfs call of a node is finished, it needs to be remove from the visited set as some other dfs call coming from some other may have this in its path....and this node needs to be included in that path.
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        DFS(graph, 0, new ArrayList<Integer>());
        return ans;
    }
    }
