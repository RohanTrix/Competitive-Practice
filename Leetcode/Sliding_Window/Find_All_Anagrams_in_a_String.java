public class Find_All_Anagrams_in_a_String
{
    // We maintain a HashMap and a fixed sliding window. The HashMap will first contain the frequency of
    // characters of the String p. Now, we move a fixed sliding window of size p.length(). And we subtract
    // 1 if a character enters the window and add 1 when it leaves the window. Whenever a letter's frequency becomes
    // 0, we remove it from the HashMap. The intuition for doing this is, when a anagram comes inside the
    // sliding window, then the frequency of each char shud be 0. And freq being zero is same as it not being in 
    // hashmap. So if no characters are in the hashmap, that is a valid window with an anagram
    public List<Integer> findAnagrams(String s, String p) {
        int win_size = p.length();
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length())return ans;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch: p.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        
        for(int i = 0; i<win_size; i++)
        {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)-1);
            if(hm.get(ch)==0)hm.remove(ch);
        }
        if(hm.size()==0)
            ans.add(0);
        for(int right = win_size; right<s.length(); right++)
        {
            char leftc = s.charAt(right-win_size);
            hm.put(leftc, hm.getOrDefault(leftc, 0)+1);
            if(hm.get(leftc)==0)hm.remove(leftc);
            char rightc = s.charAt(right);
            hm.put(rightc, hm.getOrDefault(rightc, 0)-1);
            if(hm.get(rightc)==0)hm.remove(rightc);
            if(hm.size()==0)
                ans.add(right - win_size+1);
        }
        return ans;
    }
}