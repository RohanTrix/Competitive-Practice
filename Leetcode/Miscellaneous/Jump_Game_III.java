import java.util.*;
// Normal BFS ont he array
/* We add the start node  
*/
class Jump_Game_III {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        hs.add(start);
        q.offerLast(start);
        while(!q.isEmpty())
        {
            int u = q.pollFirst();
            if(arr[u]==0) return true;

            if(!hs.contains(arr[u] + u) && arr[u]+u < arr.length)
            { q.offerLast(arr[u]+u); hs.add(arr[u]+u);}

            if(!hs.contains(u - arr[u]) && u - arr[u] >= 0)
             { q.offerLast(u - arr[u]); hs.add(u- arr[u]);}
            
            
        }
        return false;
    }
}