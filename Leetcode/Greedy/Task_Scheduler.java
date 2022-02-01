/*
    IDEA: Greedily, we should think of taking the task with the highest frequency and schedule different
          tasks in its cooldown period. So, to implement such an idea:
                
          1) First find the frequency of each character 
          2) Add all frequencies to a max PQ (chars need not be added since each frequency depicts a diff char)
          3) Now, we want to take out the max frequency element, and schedule n different tasks (if present)
             during the cooldown period of this max freq element. Since we want all n tasks to be different,
             we take out each of the top n frequencies, and store it in the stack, and then decrease their count
             by 1 and add back to PQ.
          4) In case there weren't any elements remaining in PQ, it counts as Idle time

*/

public class Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Character, Integer> freq = new HashMap<>();
        // Building freq map for each char
        for(char c: tasks)
            freq.put(c, freq.getOrDefault(c, 0)+1);
        
        // Adding all frequencies to Max PQ
        for(char ch : freq.keySet())
            pq.offer(freq.get(ch));

        // Stores total time taken
        int time = 0;
        // Stores frequencies denoting task which cannot be taken in the current cooldown period
        Stack<Integer> s = new Stack<>();

        while(!pq.isEmpty())
        {
            int curr = pq.poll();
            time++; // Time taken to do current task
            s.push(curr); // Task put in stack meaning it cannot be taken until the cooldown period is over
            
            // Special case : Questions asks us to find when all task completed, this does not include
            // any cooldown period towards the end. So, cnt counts the cooldown period at end and subtracts
            // itself from final answer.
            int cnt = 0;
            for(int t = 0; t<n; t++)
            {
                if(!pq.isEmpty())
                {
                    int next = pq.poll();
                    s.push(next);
                }
                else
                    cnt++;
            }
            while(!s.isEmpty())
            {
                int num = s.pop();
                num--;
                if(num>0)
                    pq.offer(num);
            }
            if(pq.isEmpty())time-=cnt;
            time+=n;
        }
        return time;
    }
}
