import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label {
    Map<Integer, List<Integer>> map;
    int ans[];
    public int[] dfs(int u, int par, String labels)
    {
        int f[] = new int[26];
        int label = labels.charAt(u);
        f[label-'a']++;
        for(int to : map.get(u))
            if(to != par)
            {
                int freq[] = dfs(to, u, labels);
                for(int i = 0; i<26; i++)
                    f[i]+=freq[i];
            }
        ans[u] = f[label-'a'];
        return f;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        map = new HashMap<>();
        for(int i = 0; i<n; i++)
            map.computeIfAbsent(i, k-> new ArrayList<>());
        for(int edge[] : edges)
        {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        ans = new int[n];
        dfs(0,-1, labels);
        return ans;
    }
}
