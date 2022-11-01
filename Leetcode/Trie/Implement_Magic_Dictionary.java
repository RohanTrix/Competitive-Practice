class MagicDictionary {
    // IDEA : To search for a string, do a dfs with `skip` parameter..base condition should be wordEnd AND one skip has been made
    class TrieNode
    {
        boolean wordEnd;
        char let;
        TrieNode children[] = new TrieNode[26];
        public TrieNode()
        {
            let = '\0';
        }
        public TrieNode(char ch)
        {
            let = ch;
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
            }
            curr.wordEnd = true;
        }
        public boolean dfs(TrieNode root, int idx, char s[], int skip)
        {
            if(idx == s.length)
                return root.wordEnd && skip==1;
            if(skip>1) return false;
            boolean ans = false;
            TrieNode children[] = root.children;
            if(children[s[idx] - 'a'] !=null)
                ans = ans || dfs(children[s[idx] - 'a'], idx+1, s, skip);
            for(int i = 0; i<26; i++)
            {
                if(s[idx] - 'a' == i)
                    continue;
                if(children[i]!=null)
                    ans = ans || dfs(children[i], idx+1, s, skip+1);
                if(ans) break;
            }
            return ans;
        }
    }
    
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode('\0');
    }
    
    public void buildDict(String[] dict) {
        for(String w : dict)
            root.insertString(root, w);
    }
    
    public boolean search(String s) {
        return root.dfs(root, 0, s.toCharArray(), 0);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */