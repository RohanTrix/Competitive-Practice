/**
 *      IDEA : We can use sweepline technique for this intervals problems. Apart from the start and end of a
 *             interval, we also have to manually create a Event which is a query event
 *             
 *             And this `query event` has to made for each day from 1 to 10^5. This is because, we are not only interested in
 *             the boundary points of the interval...but also the duration of the interval. Luckily, the days are only uptil 10^5.
 * 
 *             On each day, we want to find out if there is an event that is 1) Open 2) not attended yet.
 * 
 *             Now the question is...on a given day..having some open intervals...which interval should we attend?
 *             The greedy answer for this is to attend the interval that ends the earliest(means it ends before the other open intervals).
 *             
 *             So we can use a PQ to get the earliest(smallest end time) interval in open intervals. Now we also need to maintain
 *             a HashSet because there might be a long interval...that might not get attended before it reaches its END day during sweeping.
 * 
 *             Type (-1) -> Start of interval Event
 *             Type (0)  -> Query Event
 *             Type (+1) -> End of interval Event
 * 
 * 
 */

public class Maximum_Number_of_Events_That_Can_Be_Attended {
    public int maxEvents(int[][] eventArr) {
        List<Event> events = new ArrayList<>();
        // Creating events of interval's start and end
        for(int i = 0; i<eventArr.length; i++)
        {
            events.add(new Event(eventArr[i][0], -1, i));
            events.add(new Event(eventArr[i][1], 1, i));
        }
        // Creating query type events on each day
        for(int time = 1; time<=100000; time++)
            events.add(new Event(time, 0, -1));
            // Sorting based on timestamp of events for sweeplining
        Collections.sort(events, (a,b) -> a.time == b.time?a.type - b.type:a.time - b.time);
        // Stores idx of intervals with its minimum element as earliest ending interval
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(eventArr[a][1],eventArr[b][1]));
        Set<Integer> hs = new HashSet<>(); // Stores idx of intervals which is currently open
        int cnt = 0;
        for(int i = 0; i<events.size(); i++)
        {
            int j = i;
            while(j < events.size() && events.get(j).time == events.get(i).time)
            {
                
                Event curr = events.get(j);
                if(curr.type == -1)
                {
                    pq.offer(curr.ind); // Add to pq
                    hs.add(curr.ind); // Add to Hashset
                }
                else if(curr.type == 0 && !pq.isEmpty())
                {
                    // Removing all the intervals that are closed but still left in PQ
                    while(pq.size() > 0 && !hs.contains(pq.peek()))
                        pq.poll();
                    
                    // At curr day's query event...we attend the peek interval...so we remove from pq and hashset
                    if(pq.size()>0)
                    {
                        cnt++;
                        hs.remove(pq.poll());
                    }
                }
                // Close the interval
                else
                    hs.remove(curr.ind);
                j++;
            }
            i = j - 1;
        }
        return cnt;
        
    }
    private class Event
    {
        int time, type, ind;
        public Event(int time, int type, int ind)
        {
            this.time = time;
            this.type = type;
            this.ind = ind;
        }
        public String toString()
        {
            return time + " " + type + " " + ind;
        }
    }
}
