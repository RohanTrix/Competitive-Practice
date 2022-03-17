public class Score_of_Parentheses
{
    // REFER : https://youtu.be/zy7WmYm1KMo
    public int scoreOfParentheses(String str) {
        char s[] = str.toCharArray();
        Stack<String> st = new Stack<>();
        int sum = 0;
        for(char ch : s)
        {
            if(st.isEmpty() || ch == '(')
                st.push("(");
            else
            {
                if(ch == ')')
                {
                    int currLvl = 0;
                    while(!st.isEmpty() && !st.peek().equals("("))
                    {
                        currLvl+=Integer.valueOf(st.pop());
                    }
                    st.pop();
                    if(currLvl == 0) st.add("1");
                    else
                        st.push(2*currLvl+"");
                }   
            }
        }
        while(!st.isEmpty()) 
            sum+= Integer.valueOf(st.pop());
        return sum;
    }
}