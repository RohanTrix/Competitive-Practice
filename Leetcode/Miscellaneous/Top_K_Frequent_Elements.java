import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

// Min PQ Approach
public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> a.cnt - b.cnt);
        for(int key : map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k)
                pq.poll();
        }
        int ans[] = new int[k];
        while(!pq.isEmpty())
            ans[--k] = pq.poll().num;
        return ans;
        
    }
    record Pair(int num, int cnt){}
}
