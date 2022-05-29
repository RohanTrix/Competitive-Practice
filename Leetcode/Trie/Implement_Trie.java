public class Implement_Trie {
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insertString(root, word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int res[] = root.dfs(root, word);
        return res[1] > 0;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int res[] = root.dfs(root, prefix);
        return res[0] > 0;
    }
    static class TrieNode
    {
        char data;
        TrieNode children[] = new TrieNode[26];
        int pref = 0, wordEnd = 0;
        public TrieNode(char c)
        {
            this.data = c;
        }
        public void insertString(TrieNode root, String s)
        {
            TrieNode curr = root;
            curr.pref++;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch-'a'] = next;
                }
                next.pref++;
                curr = next;
            }
            curr.wordEnd++;
        }
        public int[] dfs(TrieNode root, String s) // Traverses to the node where this string ends.
        {
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null)
                    return new int[]{0,0};
                curr = next;
            }
            return new int[]{curr.pref, curr.wordEnd}; // returns array of prefix cnt and word ending here
        }
    }
}
