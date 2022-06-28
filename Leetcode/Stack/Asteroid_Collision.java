public class Asteroid_Collision {
    // Checks if collision is possible
    public boolean canCollide(int leftStone, int rightStone)
    {
        return Integer.signum(rightStone) == -1 && Integer.signum(leftStone) == 1;
    }
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int num : nums)
        {
            if(st.isEmpty() || !canCollide(st.peek(), num))
                st.push(num);
            else
            {
                // Remove elements from stack which are going rightwards and have size less than num
                while(st.size()>0 && Math.abs(st.peek()) < Math.abs(num) && canCollide(st.peek(), num))
                        st.pop();
                // If all destroyed or top of stack has non-colliding element, then insert.
                if(st.size() == 0 || !canCollide(st.peek(), num))
                    st.push(num);
                // Else if the 2 asteroids can collide and have same size...remove the stack top. Also, we do not add num to stack.
                else if(canCollide(st.peek(), num) && Math.abs(st.peek()) == Math.abs(num))
                    st.pop();
                
            }
            // System.out.println(st);
        }
        int ans[] = new int[st.size()];
        int k = 0;
        for(int num : st)
            ans[k++] = num;
        return ans;
    }
}
