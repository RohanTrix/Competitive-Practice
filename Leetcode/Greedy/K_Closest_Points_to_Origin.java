public class K_Closest_Points_to_Origin
{
    // Order priorityqueue based on distance from origin.
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        //int arr[] = new int[n];
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for( int i =0;i<n;++i)
        {
            int dist = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            pq.add(new pair(i,dist));
            if(pq.size()>k)
                pq.poll();
        }
        int ans[][] = new int[k][2];
        
        for(int i = 0; i<k; i++)
        {
            pair p = pq.poll();
            ans[i] = points[p.x];
        }
        return ans;
        
    }
    private class pair implements Comparable<pair> 
    {
        int x, dist;
        public pair(int a, int b)
        {
            x = a; dist = b;
        }
        public int compareTo(pair o)
        {
            return Integer.compare(dist, o.dist);
        }
    }
}