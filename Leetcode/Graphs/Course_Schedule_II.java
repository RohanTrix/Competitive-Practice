package Leetcode.Graphs;

import java.util.*;


class Course_Schedule_II {
    Map<Integer, Set<Integer>> edges = new TreeMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> explored = new HashSet<>();
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    boolean cycle  = false;
    
    void addNode(int u)
    {
        if (!edges.containsKey(u)) {
            edges.put(u, new TreeSet<Integer>());
        }
    }
    void addEdge(int u, int v)
    {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
    }
    public void dfs(int v)
    {
        
        if(cycle || visited.contains(v))
        {
            cycle  = true;
            return;
        }
        visited.add(v);
        for(int u : edges.get(v))
        {
            if(explored.contains(u)) continue;
            dfs(u);
            
        }
        visited.remove(v);
        explored.add(v);
        stack.offerFirst(v);
    }
    public void topsort(int n)
    {
        for(int i =0 ; i<n; i++)
        {
            if(!explored.contains(i))
                dfs(i);
        }
    }

    public int[] findOrder(int numCourses, int[][] prereq) {
        for(int i =0; i<numCourses; i++)addNode(i);
        for(int i = 0; i<prereq.length; i++)
        {
            addEdge(prereq[i][1],prereq[i][0]);
        }
        topsort(numCourses);
        if(cycle) return new int[]{};
        int res[] = new int[numCourses];
        for(int i = 0 ; i<numCourses; i++)
            res[i] = stack.pollFirst();
        return res;
    }
}