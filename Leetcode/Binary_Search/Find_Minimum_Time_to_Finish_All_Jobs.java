package Leetcode.Binary_Search;
import java.util.*;
import java.util.stream.*;
/*
We Binary Search over the Maximum Time a particular worker can be alotted. To check if answer is possible, we
CANNOT DO A GREEDY APPROACH. Hence, we need to try out all combinations usinf DFS.
The core idea is that assume at certain point of dfs searching,
    we have the following workload for 10 workers,
    workers = [10, 5, 5, 5, 5, 5, 5, 5, 5, 5]

    If we want to assign the current task jobs[curr] to someone,
    it makes no difference if we assign it to any worker whose current workload is 5.
    Therefore we can use a HashSet named visited to store searched workload such that we only search 5 once.

*/

public class Find_Minimum_Time_to_Finish_All_Jobs {
     
    public boolean possible(int jobs[], int groups[], int maxTime, int ind)
    {
        if(ind < 0) return(true); // Base case
        int k = groups.length;
        
        // Visited set for each DFS, to avoid trying same combo for 2 diff people
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < k; i++){
            int currSum = groups[i];
            if(visited.contains(currSum)) continue;
            visited.add(currSum);
            
            if(currSum + jobs[ind] <= maxTime){
                groups[i] += jobs[ind];
                if(possible(jobs, groups, maxTime, ind - 1)) return true;
                groups[i] -= jobs[ind];
            }
        }
        return false;
    }
    
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        // Lower Bound : Max Time for a person with single job
        // Upper Bound : Totol Time for a person with ALL the jobs
        int left = IntStream.of(jobs).max().getAsInt(), right = IntStream.of(jobs).sum();
        int bestAns = Integer.MAX_VALUE;
        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(possible(jobs, new int[k], mid, jobs.length-1))
            {
                bestAns = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return bestAns;
    }
}
