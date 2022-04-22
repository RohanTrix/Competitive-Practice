/*
    IDEA : Solved using Line Sweep. Has also been solved greedily in the Greedy Folder.
           If the event is a start event, then we add its interval's index to the set. This set denotes the open intervals.
           Whenever we encounter a closing event, we check whether it is still an open interval, if it is then we can shoot
           an arrow at this point. This will cause all open intervals to burst and we can further increase our count by one.
           We don't need to do anything if a closing event comes but the interval is not open.

*/
public class Minimum_Number_of_Arrows_to_Burst_Balloons
{
    public int findMinArrowShots(int[][] points) {
        List<Event> list = new ArrayList<>();
        int p = 0;
        for(int point[] : points)
        {
            list.add(new Event(point[0],0,p));
            list.add(new Event(point[1],1,p));
            p++;
        }
        Collections.sort(list, (a,b) -> Integer.compare(a.time,b.time)==0?(a.type - b.type):Integer.compare(a.time,b.time));
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i<list.size(); i++)
        {
            int j = i;
            while(j<list.size() && list.get(j).time == list.get(i).time)
            {
                Event curr = list.get(j);
                if(curr.type == 0) // Start Event 
                {
                    set.add(curr.ind);
                }
                else // Close Event
                {
                    if(set.contains(curr.ind))
                    {
                        ans++;
                        set.clear();
                    }
                }
                j++;
            }
            i = j-1;
        }
        return ans;
    }
    class Event
    {
        int time, type, ind;
        public Event(int time, int type, int ind)
        {
            this.time = time;
            this.type = type;
            this.ind = ind;
        }
    }
}