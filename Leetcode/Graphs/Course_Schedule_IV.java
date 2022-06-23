/*
    IDEA : Perform a DFS from each node...and basically build up a map of node to the children it has in its DFS tree
 */

public class Course_Schedule_IV {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    Map<Integer, Set<Integer>> children = new HashMap<>();
    boolean visited[];
    public void dfs(int u)
    {
        if(visited[u])
            return;
        visited[u] = true;
        Set<Integer> child = new HashSet<>();
        for(int to : edges.get(u))
        {
            dfs(to);
            child.add(to);
            for(int node : children.get(to))
                child.add(node);
        }
        children.put(u, child);
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prereq, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        visited = new boolean[numCourses];
        
        for(int i = 0; i<numCourses; i++) edges.put(i, new HashSet<>());
        for(int req[] : prereq)
            edges.get(req[0]).add(req[1]);
        
        for(int i = 0; i<numCourses; i++)
            dfs(i);
        
        for(int q[] : queries)
            ans.add(children.get(q[0]).contains(q[1]));
        return ans;
    }
}
