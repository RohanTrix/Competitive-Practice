import java.util.Arrays;
import java.util.PriorityQueue;

public class Divide_Intervals_Into_Minimum_Number_of_Groups {// Sweep Line Logic
    public int minGroups(int[][] intervals) {
        List<Event> list = new ArrayList<>();
        for(int inter[] : intervals)
        {
            list.add(new Event(inter[0], -1));
            list.add(new Event(inter[1], 1));
        }
        Collections.sort(list, (a,b) -> (a.time - b.time) == 0? a.type - b.type:(a.time - b.time));
        int cnt = 0; // Cnt of active intervals at any time
        maxi = 0;
        for(int i = 0; i<list.size(); i++)
        {
            int j = i;
            while(j<list.size() && list.get(i).time == list.get(j).time)
            {
                Event curr = list.get(j);
                if(curr.type == -1)
                    cnt++;
                else
                    cnt--;
                maxi = Math.max(maxi, cnt);

                j++;
            }
            i = j-1;
        }
        return maxi;
    }
    class Event
    {
        int time, type;
        public Event(int time, int type)
        {
            this.time = time;
            this.type = type;
        }
        public String toString()
        {
            return time+" "+type;
        }
    }
}

class Divide_Intervals_Into_Minimum_Number_of_Groups1 {
    public int minGroups(int[][] intervals) {
        // IDEA : PQ maintains the different groups basically...and when extending to a group, all you need
        //        is the last interval of that group(since the intervals will always be appended in a sorted order)
        //        Now, lets say we have some intervals ending at e1 < e2 < e3 inside our heap.
        //        For current interval [s,e]....we want to attach it to an interval that has a END < s
        //        Now, the claim is that...if my interval cannot extend e1(smallest end time)....then 
        //        it obvio cannot extend e2 or e3 which are anyways more than e1....
        //        So...if it can...then we replace e1 with the new ending e...otherwise we just
        //        add this interval as a new group altogether.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int inter[] : intervals)
        {
            if(pq.peek() != null && pq.peek() < inter[0])
                pq.poll();
            pq.offer(inter[1]);
        }
        return pq.size();

    }
}