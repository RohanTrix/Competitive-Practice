/*
    IDEA : Since we have to check for prefix in a String, we can use a Trie
           For each TrieNode, we maintain these additional parameters:
                1) wordEnd -- How many words end here
                2) val -- The latest updated value for string ending at curr
            


*/
public class Map_Sum_Pairs {
    /** Initialize your data structure here. */
    TrieNode root;
    private class TrieNode
    {
        char ch;
        int prefix = 0;
        TrieNode children[] = new TrieNode[26];
        int wordEnd = 0;
        int val = 0;
        public TrieNode()
        {
            ch ='\0';
        }
        public TrieNode(char ch)
        {
            this.ch = ch;
        }
        public void insertString(TrieNode root, String str, int val)
        {
            char s[] = str.toCharArray();
            TrieNode curr = root;
            
            for(char ch : s)
            {
                curr.prefix++;
                TrieNode next = curr.children[ch-'a'];
                if(next==null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch-'a'] = next;
                }
                curr = next;
            }
            curr.wordEnd++;
            curr.val = val;
        }
        public int dfs(TrieNode root)
        {
            if(root==null) return 0;
            int sum = 0;
            if(root.wordEnd>0)
            {
                sum+=root.val;
            }
            
            for(int i = 0; i<26; i++)
                sum+=dfs(root.children[i]);
            return sum;
        }
        public int prefixSum(TrieNode root, String prefix)
        {
            TrieNode curr = root;
            char s[] = prefix.toCharArray();
            
            for(char ch: s)
            {
                TrieNode next = curr.children[ch-'a'];
                if(next == null)
                    return 0;
                curr = next;
            }
            
            return dfs(curr);
        }
    }
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        root.insertString(root, key, val);
    }
    
    public int sum(String prefix) {
        return root.prefixSum(root, prefix);
    }
}
