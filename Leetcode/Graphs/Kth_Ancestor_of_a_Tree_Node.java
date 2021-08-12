package Leetcode.Graphs;
import java.util.*;
public class Kth_Ancestor_of_a_Tree_Node {
    // Required:  Binary Lifting Concept from AlgoZenith
    
    /* Idea: For the given tree, we build a `parents` table using DFS. parents[i][x] represents 
       the xth ancestor for node i where x is a power of 2. As any number can be broken into a sum of powers
       of 2. If we want to find any kth ancestor of a node, we only need to make jump wherever the ith bit is 1
       in the binary representation of k instead of making k jumps. 
    */
    
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    int parent[][];
    int depth[];
    public Kth_Ancestor_of_a_Tree_Node(int n, int[] parents) {
        // GRAPH CREATION : START
        for(int i = 0; i<n; i++) addNode(i);
        for(int i = 1; i<parents.length; i++)
            addEdge(i, parents[i]);
        // GRPH CREATION : END
        parent = new int[n][17]; // upto 16th power of 2 has been taken due to constraints (5*10^4) < 2^16
        depth = new int[n]; // Depth of each node in tree 
        dfs(0,-1,0); // Binary Lifting by traversing using DFS
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i = 16; i>=0; i--) // Traversing all 16 bits of k 
        {
            if((k & (1<<i))!=0) // if ith bit is set in k
            {
                if(node==-1) return -1; // if no ancestor exists, early exit
                node = parent[node][i]; // Jump to 2^ith ancestor
            }
        }
        return node;
        
    }
    public void dfs(int node, int prev, int dep)
    {
        // `node` : current node we are at
        // `prev` : immediate parent of current node `node`
        parent[node][0] = prev; // Setting (2^0th = 1st) ancestor of this node = immediate parent  
        depth[node] = dep; // Setting depth of current node.

        for(int i = 1; i<17; i++) // we are for powers of 2 from 1 to 16
        {
            if(parent[node][i-1]!=-1) // To handle -1 not coming as index in parent
            parent[node][i] = parent[parent[node][i-1]][i-1];
            else
            parent[node][i]  = -1;
        }
        for(int to : edges.get(node)) // Goto all neighbours except parent
        {
            if(to!=prev)
                dfs(to, node, dep+1);
        }
        
    }
    ///////////////////////////////////// ADJ LIST MAKER ///////////////////////////////////////
    public void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new HashSet<>());
    }
    public void addEdge(int u , int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
}
