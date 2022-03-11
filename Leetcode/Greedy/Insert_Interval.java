package Leetcode.Greedy;

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
            int last_st = st.peek()[0];
            int last_end = st.peek()[1];
            st.pop();
            st.push(new int[]{last_st, Math.max(last_end, al.get(i)[1])});
        }
        int ans[][] = new int[st.size()][2];
        int i = 0;
        for(int inter[] : st)
            ans[i++] = inter;
        return ans;

    }
}
