/*
 *      IDEA : Solved in One Go after looking at Tags
 *             
 *             Since the problem involves intervals having arrival time and ending times, Sweep Line should be used.
 *             We want to acheive the following:
 *                  -> Maintain which server is busy or not
 *                  -> Get the next free server in a circular fashion
 *             
 *             The key part of how I solved this is by using a Sorted Set.
 *             For example...if free servers are 1, 5, 6, 8,...and lets say the server we want is:
 * 
 *                  1) 5   -> Here 5 is directly available so we can fulfil the request and remove from freeserver set
 *                  2) 2   -> Here 5 is the closest next available server(hint for TreeSet's ceiling)
 *                  3) 9   -> Here there are no servers that are available after...so in this case we need to wrap around circularly
 *                            That is basically getting the first key in the TreeSet
 * 
 *             Now, in the sweep line, we make an Event having [time, type, ind]
 *             where time = timestamp at which this event occurs
 *                   type = 1 if the event is a start event otherwise -1.....
 *                            we want to process ending events before starting events acc. to question
 *                   ind = Index of the request
 * 
 *             Now, it is important to make the server free again after its job is done, so since the sweep line is happening
 *             on the requests...me map request `ind` to the server which is processing that request.
 * 
 * 
 *             Follow code for full logic
 *             
 * 
 */
public class Find_Servers_That_Handled_Most_Number_of_Requests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        int jobCount[] = new int[k]; // Counts the requests services by servers 0..k-1
        TreeSet<Integer> freeServers = new TreeSet<>(); // Contains servers which are 
        for (int i = 0; i < k; i++) // Initally all servers are free
            freeServers.add(i);
        Map<Integer, Integer> reqMap = new HashMap<>(); // Maps request ind -> server busy with this request
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new Event(arrival[i], 1, i));// Start Event
            events.add(new Event(arrival[i] + load[i], -1, i)); // End event
        }
        Collections.sort(events); // Sorting events for sweep line
        // Standard Sweep Line code
        for (int i = 0; i < events.size(); i++) {
            int j = i;
            while (j < events.size() && events.get(j).time == events.get(i).time) {
                Event curr = events.get(j);
                int time = curr.time, type = curr.type, ind = curr.ind; // Parameters for current event

                // If the event is a START event and there are some free servers
                if (type == 1 && !freeServers.isEmpty()) {
                    // Find the nextFree server including and after the current server
                    Integer nextFree = freeServers.ceiling(ind % k);
                    if (nextFree == null) // In case no server after this was free, so take the smallest free server(circularly it will be the next free)
                        nextFree = freeServers.first();
                    jobCount[nextFree]++; // We are assigning job to server `nextFree` so increase the no. of jobs this server will process
                    reqMap.put(ind, nextFree); // Map the current request with id = ind to server nextFree
                    freeServers.remove(nextFree); // Since server `nextFree` is now being used, so remove this from freeServers
                }
                // If event is END EVENT 
                else {
                    // It might be possible that we did not process a request since all servers were busy at that time...
                    // so that request's END event has to be skipped....Well since it wasn't serviced, it isn't added to reqMap too
                    if (reqMap.containsKey(ind)) {
                        int server = reqMap.get(ind); // Get the Server that this request(which is to be ended) is being run on
                        freeServers.add(server); // Free the server
                    }
                }
                j++;
            }
            i = j - 1;
        }
        // debug(events);
        // Get the max requests a server has processed
        int maxi = 0;
        List<Integer> ans = new ArrayList<>();
        for (int num : jobCount)
            maxi = Math.max(maxi, num);
        // Get the servers which hav processed requests = maxi
        for (int i = 0; i < k; i++)
            if (jobCount[i] == maxi)
                ans.add(i);
        return ans;
    }

    class Event implements Comparable<Event> {
        int time, type, ind;

        public Event(int time, int type, int ind) {
            this.time = time;
            this.type = type;
            this.ind = ind;
        }

        public int compareTo(Event that) {
            if (this.time == that.time)
                return this.type - that.type;
            return this.time - that.time;
        }

        public String toString() {
            return time + " " + type + " " + ind;
        }
    }
}
