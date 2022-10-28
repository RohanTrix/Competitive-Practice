/**
 *      IDEA : This question is more of a careful simulation of the Greedy Logic showed in the question.
 *             Firstly, we create 'Process' objects. Now, sort the list of processes based on the enqueTime
 *             This will give the basic ordering for the intervals. We shall also maintain a currTime variable since it
 *             is imp to tell how many processes should be considered which fall before or upto a certain currTime.
 *             We shall use a PQ called 'waiting' for the processes that are yet to be scheduled.
 *             Whenever, we pick a new process, we should poll it from the PQ which will give us the shortest duration task of smallest index.
 * 
 *             Finally, the logic is to simulate the process till we consider all processes OR if processes are waiting in PQ
 *             Now, firstly insert all the processes that have enqueTime <= currTime.
 *             It may be possible that we do not insert any process in the above while logic since it is CPU idle time. So we should directly
 *             change the currTime to the enqueTime of the next process to consider from taskList.
 *             Now, the main part is to poll the smallest duration process from waiting PQ, add it to the answer...and update the currTime
 *             by currTime+=processTime (duration of the process)
 * 
 */


public class Single_Threaded_CPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length, k = 0;
        int[] res = new int[n];
        
        PriorityQueue<Process> waiting = new PriorityQueue<>();
        List<Process> taskList = new ArrayList<>();
        for(int i = 0; i<n; i++)
            taskList.add(new Process(i, tasks[i][0], tasks[i][1]));
        Collections.sort(taskList, (a,b) -> Integer.compare(a.enqueTime, b.enqueTime));

        int i = 0, currTime = 0;
        
        while(i<taskList.size() || !waiting.isEmpty())
        {

            while(i<taskList.size() && taskList.get(i).enqueTime <= currTime)
                waiting.offer(taskList.get(i++));
            
          
            if(waiting.isEmpty())
            {
                currTime = taskList.get(i).enqueTime;
                continue;
            }
            
            Process currProcess = waiting.poll();
            currTime+=currProcess.processTime;
            res[k++] = currProcess.index;
        }
        return res;
        
        
    }
    class Process implements Comparable<Process>
    {
        int index, enqueTime, processTime;
        public Process(int index, int enqueTime, int processTime)
        {
            this.index = index;
            this.enqueTime = enqueTime;
            this.processTime = processTime;
        }
        @Override
        public int compareTo(Process that)
        {
            if(this.processTime == that.processTime)
                return Integer.compare(this.index, that.index);
            return Integer.compare(this.processTime, that.processTime);
        }
        public String toString()
        {
            return "["+index+","+enqueTime+","+processTime+"]";
        }
    }
}
