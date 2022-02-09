public class Letter_Case_Permutation
{
    char str[];
    List<String> finList = new ArrayList<>();
    public void recur(int i, StringBuilder curr)
    {
        if(i == str.length)
        {
            finList.add(curr.toString());
            return;
        }
        curr.append(str[i]);
        recur(i+1, curr);
        curr.deleteCharAt( curr.length() - 1 );
        if(str[i]>=65 && str[i]<=90)
        {
            curr.append((char)(str[i]+32));
            recur(i+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(str[i]>=97 && str[i]<=122)
        {
            curr.append((char)(str[i]-32));
            recur(i+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        str = s.toCharArray();
        recur(0, new StringBuilder());
        return finList;
    }
}