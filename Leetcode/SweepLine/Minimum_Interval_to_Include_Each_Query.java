/*
    IDEA : SWEEP LINE --- Explained in OneNote
*/

public class Minimum_Interval_to_Include_Each_Query {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        List<pair> events = new ArrayList<>(); // Putting Line Sweep Events here
        
        // TreeMap maps Interval Size ---> Set of indexes of intervals which have this size
        // TreeMap keeps size in sorted order. TreeMap contains
        TreeMap<Integer, Set<Integer>> tm = new TreeMap<>(); // PQ could have been used but it TLEs when having to remove an interval
        
        // -1 denotes interval start, 1 denotes interval end
        for(int i = 0; i<intervals.length; i++)
        {
            events.add(new pair(intervals[i][0],-1, i));
            events.add(new pair(intervals[i][1], 1, i));
        }
        // Adding Queries to event list
        for(int i = 0;i<queries.length; i++)
            events.add(new pair(queries[i],0,i));
        
        // Sort queries based on the point at which they occur
        // If they occur at same point, sort them based on their type
        Collections.sort(events, new EventComp());

        Arrays.fill(queries, -1); // We will save final answer in queries array
        
        for(int i = 0; i<events.size(); i++)
        {
            int j = i;

            while(j<events.size() && events.get(j).val == events.get(i).val)
            {
                pair curr = events.get(j);
                // If event is start event
                if(curr.type == -1)
                {

                    // 1. Calculate Interval size
                    // 2. Add the Index of the interval for which curr is a start point, to the set of interval size, Create set if doesn't exist

                    int l1 = intervals[curr.ind][0], r1 = intervals[curr.ind][1];
                    int size = r1-l1+1;
                    Set<Integer> s = tm.getOrDefault(size,new HashSet<>());
                    s.add(curr.ind);
                    tm.put(size, s);
                    
                }
                // If event is a query,
                else if(curr.type == 0)
                {
                    if(!tm.isEmpty())
                    {
                        queries[curr.ind] = tm.firstKey(); // Answer is size of shortest active interval
                    }
                }
                // If event is a end event
                else if(curr.type == 1)
                {
                    // 1. Calculate Interval size
                    // 2. Remove the Index of the interval for which curr is a end point, from the set of interval size.
                    //    Remoe the Key if the set becomes empty.
                    int l1 = intervals[curr.ind][0], r1 = intervals[curr.ind][1];
                    int size = r1-l1+1;
                    Set<Integer> s = tm.get(size);
                    s.remove(curr.ind);
                    if(!s.isEmpty())
                        tm.put(size, s);
                    else
                        tm.remove(size);
                }

                j++;
            }

            i = j-1;
        }
        return queries;
    }
    
    class EventComp implements Comparator<pair>
    {
        public int compare(pair a, pair b)
        {   
            if(Integer.compare(a.val, b.val)!=0)
                return Integer.compare(a.val, b.val);
            return Integer.compare(a.type, b.type);
        }
    }
    private class pair
    {
        int val,type, ind;
        // val : point at which event occurs
		// type : -1(start) or 0(query) or 1(end)
        // ind : Index of the interval/query in its respective array
        public pair(int v,int s, int i)
        {
            val = v;
            type = s;
            ind = i;
        }
        public String toString()
        {
            return val+" "+type+" "+ind;
        }
    }
}
