public class Remove_Duplicate_Letters
{
    // REFER : https://youtu.be/mar0BcDpwGg
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) freq[ch-'a']++;
        
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']--;
            if(hs.contains(ch)) continue;
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek()-'a']>0)
                hs.remove(st.pop());
            
            st.push(ch);
            hs.add(ch);
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) str.append(st.pop());
        return str.reverse().toString();
    }
}