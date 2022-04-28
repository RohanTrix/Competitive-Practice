/*  Solved in one go :)
    IDEA : There is no scene for DP here firstly, since the jobs chosen are independent for each worker.
           
    Observations:
        1) For a worker, out of all the possible jobs he can do, he wants to take the one with max profit.
        2) A worker B with ability more than another worker A can do all jobs A can do...and also some other jobs.
    
    Point 2 gives us a hint to sort the worker array. And we should club the diff and prof as one entity.
    Now, we since every time we want to take max profit out of all jobs (we consider that we have only considered jobs
    that curr worker can do)... so a Prefix max comes to mind.


    Follow code hints for more idea


*/
public class Most_Profit_Assigning_Work {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = profit.length;
        List<pair> list = new ArrayList<>();
        for(int i = 0; i<n; i++)
            list.add(new pair(difficulty[i], profit[i]));
        Collections.sort(list, (a,b) -> a.diff - b.diff); // Sorting [diff, profit] pairs based on difficulty
        
        int k = 0; // Pointer to jobs in list. All jobs upto k are being considered at any time. 
        int prefMax = list.get(0).prof; // Running prefix max on profit.
        int w = 0; 
        while(w<worker.length && worker[w]<list.get(0).diff)   w++; // Skipping workers who cannot do any job
        int ans = 0;
        for(; w<worker.length; w++) // For each worker, we take max profit
        {
            while(k<n && list.get(k).diff<=worker[w]) // Consider all difficulties/jobs current worker can do.
            {
                prefMax = Math.max(prefMax, list.get(k).prof); // Keep updating max profit among all these jobs
                k++;
            }
            ans+=prefMax; // For curr worker, add max profit to ans
        }
        return ans;
    }
    static class pair
    {
        int diff, prof;
        public pair(int diff, int prof)
        {
            this.diff = diff;
            this.prof = prof;
        }
    }
}
