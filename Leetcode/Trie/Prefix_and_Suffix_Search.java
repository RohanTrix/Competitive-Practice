class WordFilter {
    //  REFER for explanation only: https://youtu.be/e36Lo1sVdyo
    class TrieNode
    {
        char data;
        TrieNode children[] = new TrieNode[256];
        int idx;
        public TrieNode()
        {
            data = '\0';
            idx = -1;
        }
        public TrieNode(char ch)
        {
            this.data = ch;
            idx = -1;
        }
        public void insertString(TrieNode root, String s, int ind)
        {
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch];
                if(next == null)
                {
                    curr.children[ch] = new TrieNode(ch);
                    next = curr.children[ch];
                }
                curr = next;
            }
            curr.idx = ind;
        }
        public int findStr(TrieNode root, String s)
        {
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch];
                if(next == null) return -1;
                curr = next;
            }
            return curr.idx;
        }
    }
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int ind = 0;
        for(String w : words)
        {
            char word[] = w.toCharArray();
            StringBuilder pref = new StringBuilder();
            for(char ch : word)
            {
                pref.append(ch);
                StringBuilder suff = new StringBuilder();
                for(int i = word.length-1; i>=0; i--)
                {
                    suff.append(word[i]);
                    suff.reverse();
                    root.insertString(root, pref.toString()+'X'+suff.toString(), ind);
                    suff.reverse();
                }
            }
            ind++;
        }
    }
    
    public int f(String prefix, String suffix) {
        String word = prefix+'X'+suffix;
        return root.findStr(root, word);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */