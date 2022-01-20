/*
        IDEA: We can use a Trie as a lookup dictionary and also check if a word exists in it.
              But since Trie cannot handle permutations of letters, we store everything in Trie
              in a sorted manner. Moreover, every word is less than equal to length of 26.

              Procedure: We add to trie, all words we can make using the startWords.

                         For each word in startWords, we append 'a' to 'z' one by one to it, sort the words,
                         and insert it into the Trie.

                         For each word in targetWords, we sort these words and check for their presence in
                         the Trie. Increase count if it is present.
                         NOTE: Duplicate letter words are not allowed, but the targetWords that
                         we will search in the Trie do not have duplicate letter words, so it doesn't matter


*/

public class Count_Words_Obtained_After_Adding_a_Letter
{
    static class TrieNode
    {
        char data = '\0';
        TrieNode children[] = new TrieNode[26];
        int wordEnd;
        public TrieNode(char c)
        {
            data = c;
        }
        public void insertString(TrieNode root, char[] s)
        {
            TrieNode curr = root;
            for(char ch : s)  
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch-'a'] = next;
                }
                curr = next;
            }
            curr.wordEnd++;
        }
        public boolean searchWord(TrieNode root, char[] s)
        {
            TrieNode v = root;
            for(char ch : s)
            {
                TrieNode next = v.children[ch-'a'];
                if(next==null)
                    return false;
                v = next;
            }
            return v.wordEnd>0;
        }
    }
    public int wordCount(String[] start, String[] target) {
        TrieNode root = new TrieNode('\0');
        
        for(String s: start)
        {
            String snew = "";
            for(int i = 'a';i<='z'; i++)
            {
                snew = s+(char)i;
                char str[] = snew.toCharArray();
                Arrays.sort(str);
                root.insertString(root, str);
            }
        }
        int cnt = 0;
        for(String s: target)
        {
            char str[] = s.toCharArray();
            Arrays.sort(str);
            boolean x = root.searchWord(root, str);
            
            cnt+=x?1:0;
        }
        return cnt;
    }
}