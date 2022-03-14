/*
    IDEA : Similar to Word Break I idea. We only make a partion if the left half is a valid word.
           Rest code is like a backtracking logic similar to word break I. 
*/
public class Word_Break_II
{
    Set<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();
    public void dfs(int i, List<String> currAns, char s[])
    {
        if(i == s.length)
        {
            StringBuilder str = new StringBuilder();
            for(String word : currAns)
            {
                str.append(word);
                str.append(" ");
            }
            ans.add(str.toString().trim());
            return;
        }
        StringBuilder curr = new StringBuilder();
        for(int p = i; p<s.length; p++)
        {
            curr.append(s[p]);
            if(set.contains(curr.toString()))
            {
                currAns.add(curr.toString());
                dfs(p+1, currAns, s);
                currAns.remove(currAns.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str : wordDict) set.add(str);
        dfs(0, new ArrayList<>(), s.toCharArray());
        return ans;
    }
}