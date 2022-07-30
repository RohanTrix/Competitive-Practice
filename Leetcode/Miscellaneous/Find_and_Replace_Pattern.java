/*
 *      IDEA : We basically want to create a ONE-TO-ONE mapping for every stirng....so the idea is
 *             for each string, we make 2 hashmaps...one map maps ch1 -> ch2 and the other ch2 -> ch1
 *             This will help us check for ONE-ONE mapping....We traverse pattern str and ith str together,
 *             If the either of the corresponding characters exist in a map..with a different mapping,
 *             then it means we cannot consider mapping the current 2 characters.
 */
public class Find_and_Replace_Pattern
{
    public List<String> findAndReplacePattern(String[] words, String pat) {
        int len = pat.length();
        Map<Character, Character> map1 = new HashMap<>();  
        Map<Character, Character> map2 = new HashMap<>();  
        List<String> ans = new ArrayList<>();
        outer:
        for(String w : words)
        {
            map1.clear(); map2.clear();
            for(int i = 0; i<len; i++)
            {
                char ch1 = w.charAt(i), ch2 = pat.charAt(i);
                if((map1.containsKey(ch1) && map1.get(ch1)!= ch2) || (map2.containsKey(ch2) && map2.get(ch2)!= ch1))
                    continue outer;
                else
                {
                    map1.put(ch1, ch2); 
                    map2.put(ch2, ch1);
                }
            }
            ans.add(w);
        }
        return ans;
    }
}