/*
 *  IDEA : Consider a left to right traversal for ")(())(()".
 *         And if we consider `cnt` as the diff between open and closing braces and `size` as 
 *         size of the bracket seq being formed
 * 
 *         then our logic will be:
 *          1) cnt++ if '(' is seen
 *          2) cnt-- if ')' is seen
 *          
 *          Now, if cnt < 0 at any moment...then that means a closing bracket appears before
 *          an opening bracket. And when we arrive at cnt == 0, we know we have equal no. of
 *          opening and closing brackets...and in the proper order -> "(())" instead of "))(("
 *          SO WHENEVER CNT == 0, we can take a max(size) as it can be a candidate for final ans.
 * 
 *          BUT THIS DOES NOT SOLVE CORRECTLY FOR A CASE LIKE:   "(()"
 * 
 *          This is because...in previous logic...we ELIMINATE UNMATCHED CLOSING BRACKET IMMEDIATLY.
 *          We need to do the same thing for OPENING BRACKETS AS WELL.
 * 
 *          To solve that...we just traverse BACKWARDS and apply the exact same but opposite logic:
 *              1) cnt++ if ')' is seen
 *              2) cnt-- if '(' is seen
 * 
 *              Now if cnt<0 at any moment, we know IT IS A UNMATCHED OPENING BRACKET.
 */

// T.C = O(n)...S.C = O(1)
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String str) {
        int cnt = 0, size = 0;
        int maxi1 = 0, maxi2 = 0;
        char s[] = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(')
                cnt++;
            else
                cnt--;
            size++;
            if (cnt < 0) {
                cnt = 0;
                size = 0;
            } 
            else if (cnt == 0)
                maxi1 = Math.max(maxi1, size);
        }
        size = 0;
        cnt = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == ')')
                cnt++;
            else
                cnt--;
            size++;
            if (cnt < 0) {
                cnt = 0;
                size = 0;
            } else if (cnt == 0)
                maxi2 = Math.max(maxi2, size);
        }
        return Math.max(maxi1, maxi2);

    }
}

/*
 * IDEA : There are certain characters that make a bracket sequence invalid.
 * Let's call such positions partitionPoints.
 * We just need to find these unmatched brackets (both '(' and ')') since the
 * strings that lie between these partition points
 * are valid brackets. Hence, between every 2 consecutive partition points, the
 * length of the string between it(which is a valid string).
 * And the max of length all such strings in between the partition points, is
 * the longest valid paranthesis.
 */
public class Longest_Valid_Parentheses1 {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        List<Integer> partitionPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(i);
            else {
                if (st.isEmpty())
                    partitionPoints.add(i);
                else
                    st.pop();
            }
        }
        while (!st.isEmpty())
            partitionPoints.add(st.pop());
        partitionPoints.add(-1);
        partitionPoints.add(n);
        Collections.sort(partitionPoints);

        int maxi = 0;
        for (int i = 0; i < partitionPoints.size() - 1; i++) {
            int left = partitionPoints.get(i);
            int right = partitionPoints.get(i + 1);
            maxi = Math.max(maxi, right - left - 1);
        }
        return maxi;
    }
}