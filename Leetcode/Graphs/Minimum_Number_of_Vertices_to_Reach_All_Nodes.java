import java.util.*;

// IDEA : Calculate the indegree of each node. All nodes with 0 indegree are part of answer.

public class Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int indeg[] = new int[n];
        for(int i =0; i<edges.size(); i++)
        {
            int to = edges.get(i).get(1);
            indeg[to]++;
        }
        for(int i = 0; i<n; i++)
            if(indeg[i]==0)res.add(i);
        return res;
    }
}
