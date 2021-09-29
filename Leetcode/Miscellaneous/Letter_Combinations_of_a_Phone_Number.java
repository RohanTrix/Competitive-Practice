import java.util.*;
public class Letter_Combinations_of_a_Phone_Number {
    List<String> res = new ArrayList<>();
    Map<Character,String> mp;
    public void dfs(StringBuilder curr, String digits, int i)
    {
        if(i==digits.length())
        {
            res.add(curr.toString());
            return;
        }
        for(char ch : mp.get(digits.charAt(i)).toCharArray())
        {
            curr.append(ch);
            dfs(curr, digits, i+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return res;
        mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        dfs(new StringBuilder(), digits, 0);
        return res;
    }
}
