// IDEA : Simulation Type Problem
public class Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int k = 0;
        for(int i = 0; i<pushed.length; i++)
        {
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[k])
            {
                st.pop(); 
                k++;
            }
        }
        return st.size() == 0;
    }
}
