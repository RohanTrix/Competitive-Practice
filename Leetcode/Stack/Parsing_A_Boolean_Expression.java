/*
    IDEA : Solved in One Go :)
           Its a simple use of stack. Just a little implementation centric. To ease the conversion between
           boolean to symbolic form and vice versa. I use 2 maps, map and revmap for that.
           We will skip ' , ' symbol because its useless.
           We keep inserting onto the stack everything until we
           reach a closing bracket which means we need to start processing. Now I put all exprs
           into a arraylist until a opening bracket is seen on stack top. After removing
           the bracket we get the operator. So now, we just need to apply the operator (& | !)
           on the characters in arralist. This is easily done since we can just use our map to
           get the boolean values. And after getting final boolean result, we revmap it to character
           and push it on stack.

           Finally there will be one value left in the stack whose boolean version is the answer.

*/
public class Parsing_A_Boolean_Expression {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> st = new Stack<>();
        Map<Character, Boolean> map = new HashMap<>();
        Map<Boolean, Character> revmap = new HashMap<>();
        map.put('f', false);
        map.put('t', true);
        revmap.put(false, 'f');
        revmap.put(true, 't');
        
        for(char ch : exp.toCharArray())
        {
            if(ch == ',') continue;
            if(st.isEmpty() || ch !=')')
                st.push(ch);
            
            else
            {
                List<Character> list = new ArrayList<>();
                while(st.peek()!='(')
                {
                    list.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                if(op== '&')
                {
                    boolean ans = true;
                    for(char c : list)
                    {
                        ans = ans && map.get(c);
                    }
                    st.push(revmap.get(ans));
                }
                else if (op == '|')
                {
                    boolean ans = false;
                    for(char c : list)
                    {
                        ans = ans || map.get(c);
                    }
                    st.push(revmap.get(ans));
                }
                else
                {
                    st.push(revmap.get(!map.get(list.get(0))));
                }
            }
        }
        return map.get(st.pop());
    }
}
