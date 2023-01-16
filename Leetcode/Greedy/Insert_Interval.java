package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

// IDEA : Add the new interval to the list containing the other intervals. Sort it.
//        Then use merge interval logic using stack.



public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> al = new ArrayList<>();
        for( int arr[]: intervals) al.add(arr);
        al.add(newInterval);
        
        Collections.sort(al, (a,b) -> a[0] - b[0]);
        
        Stack<int[]> st = new Stack<>();
        
        st.add(al.get(0));
        for(int i = 1; i<al.size(); i++)
        {
            if(st.peek()[1]< al.get(i)[0]){
                
                st.push(new int[]{al.get(i)[0], al.get(i)[1]});
                continue;
            }

            st.peek()[1] = Math.max(st.peek()[1], al.get(i)[1]);
        }
        int ans[][] = new int[st.size()][];
        int i = 0;
        for(int inter[] : st)
            ans[i++] = inter;
        return ans;

    }
}
