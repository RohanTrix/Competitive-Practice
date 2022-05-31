package Leetcode.Trie;

/**
 *      IDEA : We first make a Trie of the dictionary words and at the ending node of a word, we also store the corresponding string.
 *             Now, we traverse on each each word in the sentence. 
 *             For each word, we traverse its characters and at the same time we traverse deep in the Trie. If any any time,
 *             there is no path down from a node for a character, it means that a prefix word from dict does not exist for this word.
 *             We return "" to denote no change required. But if while traversing, we come at a node with node.pref>0, it means this
 *             is the shortest prefix for the word in the sentence..and we return str stored at this node to be replaced in the ans.
 */

public class Replace_Words {
    static class TrieNode
    {
        char ch;
        int pref = 0, wordEnd = 0;
        String word;
        TrieNode children[] = new TrieNode[26];
        public TrieNode(char ch)
        {
            this.ch = ch;
        }
        public void insertString(TrieNode root, String word)
        {
            TrieNode curr = root;
            for(char ch : word.toCharArray())
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch-'a'] = next;
                }
                curr = next;
            }
            curr.pref++;
            curr.word = word;
        }
        public String searchPrefix(TrieNode root, String word)
        {
            TrieNode curr = root;
            
            for(char ch : word.toCharArray())
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null) return "";
                if(next.pref>0) return next.word;
                curr = next;
            }
            return "";
            
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode('\0');
        for(String w : dictionary)
            root.insertString(root, w);
        String arr[] = sentence.split(" ");
        for(String word : arr)
        {
            String change = root.searchPrefix(root, word);
            if(change.length()!=0) ans.add(change);
            else ans.add(word);
        }
        StringBuilder str = new StringBuilder();
        for(String s : ans) str.append(s+" ");
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}
