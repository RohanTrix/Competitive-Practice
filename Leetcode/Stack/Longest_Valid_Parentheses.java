/*
    IDEA : There are certain characters that make a bracket sequence invalid. Let's call such positions partitionPoints.
           We just need to find these unmatched brackets (both '(' and ')') since the strings that lie between these partition points
           are valid brackets. Hence, between every 2 consecutive partition points, the length of the string between it(which is a valid string).
           And the max of length all such strings in between the partition points, is the longest valid paranthesis.
*/
public class Longest_Valid_Parentheses
{
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        List<Integer> partitionPoints = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
                st.push(i);
            else
            {
                if(st.isEmpty()) partitionPoints.add(i);
                else
                    st.pop();
            }
        }
        while(!st.isEmpty())
            partitionPoints.add(st.pop());
        partitionPoints.add(-1); partitionPoints.add(n);
        Collections.sort(partitionPoints);

        int maxi = 0;
        for(int i = 0; i<partitionPoints.size()-1; i++)
        {
            int left = partitionPoints.get(i);
            int right = partitionPoints.get(i+1);
            maxi = Math.max(maxi, right - left - 1);
        }
        return maxi;
    }
}