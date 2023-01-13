import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *   IDEA : Since the tree is rooted, it gives us a hint to get an answer for a particular node based on its subtree.
 *          So we do a DFS starting from root node and at every node, we find out the longest path that crosses that node. For this,
 *          we send a DFS to its neighbours and each neighbour returns the longest valid path ending at that node. Finally out of all
 *          the neighbours having a diff char value, we will pick the largest 2. Current node plus the largest 2 valid branch lengths
 *          will be the length of the longest path at current node. We will maximise like this for each node. And we will return from
 *          the current node the longest path going downwards or basically ending at current node.
 * 
 */


public class Longest_Path_With_Different_Adjacent_Characters
{
    Map<Integer, List<Integer>> map;
    int maxi;
    public int dfs(int u, char s[])
    {
        int b1 = 0, b2 = 0; // max, second max
        for(int to : map.getOrDefault(u, new ArrayList<>()))
        {
            int branchLen = dfs(to, s);
            if(s[to]!=s[u])
            {
                if(branchLen > b1)
                {
                    b2 = b1;
                    b1 = branchLen;
                }
                else if(branchLen>b2)
                {
                    b2 = branchLen;
                }
            }
        }
        // debug(b1, b2);
        maxi = Math.max(maxi,1 + b1 + b2);
        return 1 + b1;
    }
    public int longestPath(int[] parent, String s) {
        map = new HashMap<>();
        maxi = 1;
        for(int i = 0; i<parent.length; i++)
            map.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        
        dfs(0, s.toCharArray());
        return maxi;
    }
}