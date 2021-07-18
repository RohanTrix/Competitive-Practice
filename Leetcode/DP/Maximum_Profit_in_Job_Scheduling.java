package Leetcode.DP;

// REFER in given order, the problem is tough but very good use of DP + Bianry Search
// 1) https://youtu.be/cr6Ip0J9izc
// 2) https://youtu.be/XJp-aOn35y4
// 3) https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408957/DP%2BBinary-search-(Java)


import java.util.*;
class Job
{
    int start, end, profit;
    public Job(int st, int e, int p)
    {
        start = st;
        end = e;
        profit = p;
    }
}
class Comp implements Comparator<Job>
{
    public int compare(Job j1, Job j2)
    {
        return Integer.compare(j1.end, j2.end);
    }
}


public class Maximum_Profit_in_Job_Scheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit){
        
        int n = startTime.length;
        ArrayList<Job> al = new ArrayList<>();
        for(int i=0; i<n;i++)
        {
            al.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(al, new Comp());
        Arrays.sort(endTime);
        int dp[] =  new int[n];
        dp[0] = al.get(0).profit;
        for(int i = 1; i<n; i++)
        {
            int st = al.get(i).start;
            int end = al.get(i).end;
            int pf = al.get(i).profit;
            
            // not scheduling current job
            dp[i] = dp[i-1];
            
            // scheduling current job
            int lastIndex = search(al, i);
            if(lastIndex!=-1)
                pf+=dp[lastIndex];
                
                
            dp[i] = Math.max(dp[i], pf);
                
        }

        
        return dp[n-1];
    }
    public int search(ArrayList<Job> al, int index)
    {
        int left = 0;
        int right = index - 1;
        int bestAns = -1;
        
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            if(al.get(mid).end <= al.get(index).start)
            {
                bestAns = mid;
                left = mid+1;
            }
            else
                right = mid - 1;
        }
        return bestAns;
    } 
}
