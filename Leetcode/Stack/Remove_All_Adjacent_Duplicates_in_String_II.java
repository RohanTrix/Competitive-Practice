/**
 * IDEA : We store pairs of char and their continuous cnt in the stack.
 *        So whenenver a new char comes, if it matches with previous char, we increment its cnt.
 *        Else, we just add a new pair (ch, 1).
 *        We always perform a check if the cnt of characters has reached k, then  we pop this whole pair off.
 */

public class Remove_All_Adjacent_Duplicates_in_String_II {
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(!st.isEmpty() && ch == st.peek().ch)
                st.peek().cnt++;
            else
                st.push(new pair(ch, 1));
            if(st.peek().cnt == k)
                st.pop();
        }
        StringBuilder str = new StringBuilder();
        for(pair p : st)
        {
            for(int i = 0; i<p.cnt; i++)
                str.append(p.ch);
        }
        return str.toString();
    }
    static class pair
    {
        char ch; 
        int cnt;
        public pair(char ch, int cnt)
        {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
