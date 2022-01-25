public class The_Skyline_Problem
{
    // Logic explained in OneNote
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<pair> events = new ArrayList<>();
        int n = buildings.length;
        for(int b[]:buildings)
        {
            events.add(new pair(b[0], 0, b[2]));
            events.add(new pair(b[1],1, b[2]));
        }
        Collections.sort(events); // Sorted events to perform seep line on each starting and ending point as events
        
        // Max Priority Queue for getting Max Height of building
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  
        List<List<Integer>> res = new ArrayList<>();
        // Sweep Line Algo
        // We iterate on each event
        for(int i = 0; i<events.size(); i++)
        {
            int j = i; // j will be the pointer which iterates on all events at point x
            int prevHeight = pq.peek()==null?0:pq.peek(); // Keep track of original height
            //Iterate on all events with same x
            while(j<events.size() && events.get(j).p == events.get(i).p)
            {
                // Do something
                pair curr = events.get(j);
                if(curr.type==0)
                    pq.add(curr.height);
                else
                    pq.remove(curr.height);
                j++;
            }
            // Since i will be updated in next iteration, so j-1 instead of j
            i = j-1;
            int newHeight = pq.peek()==null?0:pq.peek();
            if(prevHeight==newHeight) continue; // If height has not changed, skip
            
            List<Integer> coor = new ArrayList<>();
            coor.add(events.get(i).p); coor.add(pq.peek()==null?0:pq.peek());
            res.add(coor);
        }
        return res;
    }
    private class pair implements Comparable<pair>
    {
        int p, height;
        int type;
        public pair(int a, int se, int v)
        {
            p = a;
            type = se;
            height = v;
        }
        @Override
        public int compareTo(pair o)
        {
            return Integer.compare(p, o.p);
        }
        public String toString()
        {
            return p+" "+height+" "+type;
        }
    }
}