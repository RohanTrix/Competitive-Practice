"""
// JAVA SOLUTION:

class Solution {
    public Map<Integer, Set<Integer>> edges = new TreeMap<>();
    public Set<Integer> visited = new HashSet<Integer>();
    public Set<Integer> explored = new HashSet<Integer>();
    public boolean cycle = false;
    public void addNode(int u) {
        if (!edges.containsKey(u)) {
        edges.put(u, new TreeSet<Integer>());
      }
    }
    
     public void addEdge(int u, int v) {
        addNode(u);
        addNode(v);
        edges.get(u).add(v);
    }

    void dfs(int v)
    {
        if(visited.contains(v)){
            cycle = true;
            return;
        }
        visited.add(v);
        for(int u : edges.get(v))
            {
            
                if(!explored.contains(u))
                dfs(u);
            }
        visited.remove(v);
        explored.add(v);
      }
    public boolean canFinish(int num, int[][] pre) {
        for(int i =0; i<num; i++)
        {
            addNode(i);
        }
        for(int i =0; i<pre.length; i++)
        {
            addEdge(pre[i][1], pre[i][0]);
        }
        
        for(int i =0; i<num;i++)
            {
                if(!explored.contains(i))
                    dfs(i);
            }
        System.out.println(edges);
        return !cycle;
    }
}
"""



class Course_Schedule_II:
    # REFER:- https://youtu.be/EgI5nU9etnU
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        
        preMap = {i:[] for i in range(numCourses)}
        
        for crs, pre in prereq:
            preMap[crs].append(pre)
            
        vis = set()
        def dfs(crs):
            if crs in vis:
                return False
            if len(preMap[crs])==0:
                return True
            
            vis.add(crs)
            for j in preMap[crs]:
                if dfs(j)==False: return False
            vis.remove(crs)
            preMap[crs] = []
            return True
        
        for i in range(numCourses):
            if not dfs(i): return False
        return True