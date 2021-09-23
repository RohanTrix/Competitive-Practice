/* Idea :
        We will use the fact that if all the neighbour nodes of a node N are safe nodes, then
        N is also a safe node. We can perform a DFS on each node. For every neighbour,
        we first send it for DFS so that the whole subtree of that neighbour gets
        explored. After a neighbour is fully explored( i.e its dfs is over), we can
        check if this neighbour was marked as a safeNode or not.
        Hence for the current node, if and only if all its neighbours are safeNodes, we 
        can mark this node as a safeNode as well.

*/
package Leetcode.Graphs;
import java.util.*;
public class Find_Eventual_Safe_States
{
    boolean visited[];
    boolean safeNodes[]; // Makrs which nodes are safe
    public void dfs(int u, int[][] graph)
    {
        //if(visited[u])return;
        visited[u] = true;
        boolean f = true;// TRUE if all neighbours are safe
        
        for(int to : graph[u])
        {
            if(!visited[to])
                dfs(to, graph);
            if(!safeNodes[to])f = false; // After dfs of neigbour over, check if it is marked safe
        }
        if(f)safeNodes[u] = true;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        Arrays.fill(visited, false);
        safeNodes = new boolean[n];
        for(int i = 0; i<n; i++)
        {
            if(!visited[i])
                dfs(i,graph);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            if(safeNodes[i])res.add(i);

        return res;
        
    }
}