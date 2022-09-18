package Leetcode.Trie;

/**
 *      IDEA : For tracking prefixes, Trie is very efficient. When building the trie for a word,
 *             we update the pref value by one denoting one word has a prefix upto this.
 * 
 *             After we have built a trie like this, the ith answer is = <sum of pref values>
 *             down the path for ith word.
 * 
 * 
 */


public class Sum_of_Prefix_Scores_of_Strings {
    class TrieNode
    {
        char ch;
        TrieNode children[];
        int pref;
        public TrieNode(char ch)
        {
            this.ch = ch;
            children = new TrieNode[26];
        }
        public void insertString(TrieNode root, String s)
        {
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch - 'a'];
                if(next == null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch - 'a'] = next;
                }
                curr = next;
                curr.pref++;
            }
        }
        public int searchPref(TrieNode root, String s)
        {
            int sum = 0;
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                curr = curr.children[ch - 'a'];
                sum+=curr.pref;
            }
            return sum;
            
        }
    }
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode('\0');
        for(String word : words)
            root.insertString(root, word);
        
        int ans[] = new int[words.length];
        for(int i = 0; i<ans.length; i++)
            ans[i] = root.searchPref(root, words[i]);
        return ans;
        
    }
}
