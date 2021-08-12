package Leetcode.StringAlgo;

class Design_Add_and_Search_Words_Data_Structure {

    
    TrieNode root;
    boolean found = false;
    static class TrieNode
    {
        char data;
        TrieNode children[] = new TrieNode[128];
        boolean wordEnd;
        public TrieNode()
        {
            data = '\0';
            wordEnd = false;
        }
        public TrieNode(char data)
        {
            this.data = data;
        }
        public void insertString(TrieNode root, String s)
        {
            TrieNode v = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = v.children[ch];
                if(next==null)
                {
                    next = new TrieNode(ch);
                    v.children[ch] = next;
                }
                v = next;
            }
            v.wordEnd = true;
        }
        public boolean dfs(TrieNode root, String s, int ind)
        {
            
            if(ind==s.length())
            {
                return root.wordEnd;
            }
            //System.out.println(s.charAt(ind));
            if(s.charAt(ind) == '.')
            {
                boolean ans = false;
                for(int i=0; i<128; i++)
                {
                    if(root.children[i]!=null)
                        ans = ans || dfs(root.children[i], s, ind+1);
                }
                return ans;
            }
            return (root.children[s.charAt(ind)]!=null) && dfs(root.children[s.charAt(ind)], s, ind +1);
        }
    }
    public Design_Add_and_Search_Words_Data_Structure() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        root.insertString(root,word);
    }
    
    public boolean search(String word) {
        //found = false;
        return root.dfs(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */