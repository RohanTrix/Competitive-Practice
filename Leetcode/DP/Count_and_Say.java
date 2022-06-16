public class Count_and_Say {
    // IDEA : In every iteration, we build the next sequence using our previous iteration's sequence.
    // The logic to build the next string is to keep a running counter of the continuous same chars..
    // as soon as the char changes, the add the previous char's continuous count and that char to
    // the new string being formed. 
    public String countAndSay(int n) {
        String old = "";
        for(int i = 0; i<n; i++)
        {
            StringBuilder curr = new StringBuilder();
            if(old.length() == 0)
                old = "1";
            else
            {
                char prev = old.charAt(0);
                int cnt = 0;
                for(char ch : old.toCharArray())
                {
                    if(ch == prev) cnt++;
                    else
                    {
                        curr.append(cnt);
                        curr.append(prev);
                        prev = ch;
                        cnt = 1;
                    }
                }
                curr.append(cnt);
                curr.append(prev);
                old = curr.toString();
            }
        }
        return old;
    }
}
