package Leetcode.Stack;

// IDEA : Use Stack to process. Hard to explain.

public class Simplify_Path {
    public String simplifyPath(String path) {
        Stack<Character> st = new Stack<>();
        if(path.charAt(path.length()-1) !='/');
            path+='/';
        for(char ch : path.toCharArray())
        {
            if(ch == '/')
            {
                if(st.isEmpty())
                    st.push(ch);
                else
                {
                    StringBuilder s = new StringBuilder();
                    while(st.peek() != '/')
                    {
                        s.append(st.pop());
                    }
                    //System.out.println(st);
                    if(s.toString().equals("."))
                        continue;
                    else if(s.toString().equals(".."))
                    {
                        st.pop();
                        while(!st.isEmpty() && st.peek() !='/')
                            st.pop();
                        
                    }
                    else
                    {
                        s.reverse();
                        for(char c : s.toString().toCharArray())
                            st.push(c);
                        if(s.length()!=0)
                            st.push('/');
                    }
                }
            }
            else
                st.push(ch);
            if(st.isEmpty()) st.push('/');
        }
        if(st.isEmpty()) return "/";
        if(st.size()!=1 && st.peek()=='/') st.pop();
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) str.append(st.pop());
        str.reverse();
        return str.toString();
    }
}
