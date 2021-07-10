package Leetcode.Greedy;
import java.util.*;
class Merge_Intervals {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1)return intervals;
        
        // Converting array of arrays to ArrayList of arrays
        ArrayList<int[]> al = new ArrayList<>();
        for( int arr[]: intervals) al.add(arr);
        
        // Sorting the arraylist based on the start time 
        Collections.sort(al, (a,b) -> a[0] - b[0]);
        Stack<int[]> s = new Stack<>();


        s.push(al.get(0));

        for(int i=1;i<al.size();++i)
        {
            // st and end are the start and end times of the 
            // next interval to either be added or merged with the current interval
            int st = al.get(i)[0];
            int end = al.get(i)[1];
            
            // curr_st and curr_end are the start and end times of 
            // the current interval at the top of the stack.
            int curr_st = s.peek()[0];
            int curr_end = s.peek()[1];
            
            // If the interval cannot be merged, we add the interval to the top of stack and continue; 
            if(curr_end<st)
            {
                s.push(al.get(i));
                continue;
            }

            // Create the merged interval using the current start..and the end time which takes
            // us farthest in time.
            int latAdd[] = {curr_st,Math.max(curr_end,end)};

            // Remove the top interval and add the merged interval
            s.pop();
            s.push(latAdd);
        }
        // Return array of arrays as answer
        int[][] finAns = s.toArray(int[][]::new);
        return finAns;
    }
}