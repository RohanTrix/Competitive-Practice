public class Evaluate_the_Bracket_Pairs_of_a_String {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> list : knowledge)
            map.put(list.get(0), list.get(1));
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(st.isEmpty() || ch !=')')
                st.push(ch);
            else
            {
                StringBuilder str = new StringBuilder();
                while(st.peek()!='(')
                    str.append(st.pop());
                st.pop();
                for(char c : map.getOrDefault(str.reverse().toString(), "?").toCharArray())
                    st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
            ans.append(st.pop());
        return ans.reverse().toString();
    }
}
