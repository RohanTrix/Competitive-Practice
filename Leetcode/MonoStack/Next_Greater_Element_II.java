public class Next_Greater_Element_II
{
    // IDEA:  Repeat the array twice and then use Monostack logic to get next greater element. 
    //        Carefully mod the the index when inserting into the stack so that it comes at the correct
    //        index in the answer array
    public int[] nextGreaterElements(int[] org) {
        int n = org.length;
        int nums[] = new int[2*n];
        for(int i = 0; i<2*n; i++) nums[i] = org[i%n];
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st =  new Stack<Integer>();
        for(int i = 0; i<2*n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
            {
                ans[st.pop()] = nums[i];
            }
            st.push(i%n);
        }
        return ans;
    }
}