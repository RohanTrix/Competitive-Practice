/**
 * IDEA : First we build the graph based on the edges.
 *        Now, this simply becomes a graph coloring problem. The idea is to do a DFS. As soon as we arrive at a node, we 
 *        try to MARK a node with some color in range [1,4]. By 'trying to mark', I mean
 *        that if we mark a node with color X...then all the neighbours of this node shud either be unmarked(color=0) or
 *        be marked with a color other than X.
 * 
 *        `validColor` denotes this -> whether or not the node can be colored with current color.
 * 
 *        Next, if validColor=true, then we want to assign this color to current node, and dfs to other unvisited nodes.
 *        ALSO, we break just after that, because we have found a valid color for current node and nodes being called in the
 *        subtree of current node will automatically adjust to our current node's chosen color.
 *        
 *        Basically assigned colors greedily.
 *        Once we fix a valid color for current node, we do not need to change or try other colors.
 *        
 */

public class Flower_Planting_With_No_Adjacent {
    Map<Integer, List<Integer>> edges = new HashMap<>();
    int color[];
    public void dfs(int u)
    {
        for(int i = 1; i<=4; i++)
        {
            boolean validColor = true;
            for(int to : edges.get(u))
                if(color[to] == i) 
                    validColor = false;
            
            if(!validColor) continue;
            color[u] = i;
            for(int to : edges.get(u))
                if(color[u] == 0)
                    dfs(to);
            break;
        }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        color = new int[n];
        for(int i = 0; i<n; i++) edges.put(i, new ArrayList<>());
        for(int path[] : paths)
        {
            edges.get(path[0]-1).add(path[1]-1);
            edges.get(path[1]-1).add(path[0]-1);
        }
        for(int i = 0; i<n; i++)
            if(color[i] == 0)
                dfs(i);
        
        return color;
    }
}
