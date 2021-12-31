public class Furthest_Building_You_Can_Reach {
    // REFER: https://youtu.be/wAxhnUhXvHE
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, bestAns = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 1; i<n; i++)
        {
            int diff = heights[i] - heights[i-1];
            if(diff<=0)continue;
            
            pq.add(diff);

            if(pq.size()>ladders)
            {
                bricks -= pq.poll();
            }
            if(bricks<0) return i-1;
        }
        return n-1;
        
    }
}
