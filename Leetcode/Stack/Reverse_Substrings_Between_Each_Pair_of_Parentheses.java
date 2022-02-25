package Leetcode.Stack;

/*
    IDEA : We use a stack to find out what substring should be reversed and use a queue to aid in adding a string in reversed order.
           1) If its a letter or a Opening Bracket, we insert in stack.
           2) If we encounter a closing bracket, we want to reverse everything uptil the first opening bracket. So we add all these into
              a queue and then we add it back to the stack which will now have inserted it into a reverse order.
            3) Finally we take out the string from the stack and then reverse it(since we are removing from stack..and removing a string
                from stack naturally gives a reversed order) to get our final answer.
*/
public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        
        for(char ch : s.toCharArray())
        {
            if(Character.isLetter(ch) || ch == '(')
                st.push(ch);
            else
            {
                while(st.peek()!='(')
                    q.offer(st.pop());
                st.pop();
                while(!q.isEmpty())
                    st.push(q.poll());
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty())
            str.append(st.pop());
        str.reverse();
        return str.toString();
    }
}
