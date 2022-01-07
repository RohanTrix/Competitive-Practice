import java.util.Stack;
// We traverse and push to stack every time. Everytime during traversing,
//  if top of stack after pushing contains a operator,
// then we check if top of stack if a operator, and the two elements in stack below it are 
// integers, then we compute their value and push them back in stack.
public class Evaluate_Reverse_Polish_Notation {
    public boolean isOp(String str)
    {
        return str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        
        for(String str : tokens)
        {
            s.push(str);
            if(isOp(str))
            {
                String op = s.pop();
                String num2 = s.pop();
                String num1 = s.pop();
                if(!isOp(num1) && !isOp(num2))
                {
                    int n1 = Integer.valueOf(num1), n2 = Integer.valueOf(num2);
                    if(op.equals("*"))
                        s.push(String.valueOf(n1 * n2));
                    else if(op.equals("+"))
                        s.push(String.valueOf(n1 + n2));
                    else if(op.equals("-"))
                        s.push(String.valueOf(n1 - n2));
                    else 
                        s.push(String.valueOf(n1 / n2));
                }
                else
                {
                    s.push(num1);
                    s.push(num2);
                    s.push(op);
                }
            }
        }
        return Integer.valueOf(s.pop());
    }
}
