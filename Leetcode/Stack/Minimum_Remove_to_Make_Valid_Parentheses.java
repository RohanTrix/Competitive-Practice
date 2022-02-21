/*
    IDEA : Since this is some kind of bracket matching problem, we can think of
           using a Stack. Many times we are able to solve the stack problems using a
           single variable which keeps count of opening and closing bracket. To solve this,
           we need a mix of both ideas

           APPROACH :
           We want to return a string. So when we add a char to it, we also keep a variable
           k which stores the index at which curr char is going to be added. This is because we
           want to do the following

                > During the first pass, we want to filter out unmatched ')' characters. This can
                  be acheived by simply keeping a counter c...as soon as the counter goes below 0,
                  it means we have found an unmatched ')'.
                  Now, apart from this, we want to store the indexes of all the '('
                  in the newly formed string in a stack. The reason we do this is that when we will encounter
                  a ')', we shall pop the top of the stack to show that the stack top's bracket in the 
                  newly formed string is valid.

*/
public class Minimum_Remove_to_Make_Valid_Parentheses
{
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        int c = 0, k = 0;
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
            {
                str.append(ch); k++; continue;
            }
            if(ch == '(')
            {
                str.append(ch); c++; 
                st.push(k);
                k++;
            }
            else
            {
                c--;
                if(c>=0)
                {
                    str.append(ch);
                    k++;
                    st.pop();
                }
                else
                    c = 0;
            }
        }
        for(int i = str.length()-1; i>=0; i--)
        {
            if(!st.isEmpty() && i==st.peek())
            {
                str.deleteCharAt(st.pop());
            }
        }
        return str.toString();
    }
}