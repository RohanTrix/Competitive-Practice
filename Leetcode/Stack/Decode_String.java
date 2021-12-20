package Leetcode.Stack;

// Self Written Explanation Here : 
//
//      https://leetcode.com/problems/decode-string/discuss/1635692/Approach-%3A-Stack-oror-CLEAR-EXPLANATION


public class Decode_String {
    public String decodeString(String word) {
        Stack<Character> s = new Stack<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (ch == ']') 
            {
                StringBuilder str = new StringBuilder();
                while (Character.isLetter(s.peek()))
                    str.append(s.pop());

                s.pop();
                str.reverse();

                StringBuilder num = new StringBuilder();
                while (!s.isEmpty() && Character.isDigit(s.peek()))
                    num.append(s.pop());
                num.reverse();
                int val = Integer.valueOf(num.toString());

                for (int times = 0; times < val; times++)
                    for (int p = 0; p < str.length(); p++)
                        s.push(str.charAt(p));
            } else
                s.push(ch);

        }

        StringBuilder fin = new StringBuilder();
        while (!s.isEmpty())
            fin.append(s.pop());
        fin.reverse();
        return fin.toString();
    }
}
