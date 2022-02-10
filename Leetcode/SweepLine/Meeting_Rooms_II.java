/*
        IDEA : Using Sweep Line, we can keep track of maximum number of rooms we
               need at any time stamp.
*/
public class Meeting_Rooms_II {
    public int solve(int[][] A) {

        List<Event> events = new ArrayList<>();
        for(int e[]:A)
        {
            events.add(new Event(e[0], 0));
            events.add(new Event(e[1], 1));
        }
        Collections.sort(events);
        int rooms = 0, ans = 0;;
        for(int i = 0; i<events.size(); i++)
        {
            int j = i;
            while(j<events.size() && events.get(j).time == events.get(i).time)
            {
                Event curr = events.get(j);
                if(curr.type == 0)
                    rooms++;
                if(curr.type == 1)
                    rooms--;
                j++;
            }
            ans = Math.max(ans, rooms);
            i = j-1;
            
        }
        return ans;
    }
    static class Event implements Comparable<Event>
    {
        int time, type;
        public Event(int pp, int t)
        {
            time = pp;
            type = t;
        }
        public int compareTo(Event p)
        {
            if(Integer.compare(time, p.time) != 0)
                return Integer.compare(time, p.time);
            return Integer.compare(type, p.type);
        }
    }
    
}
