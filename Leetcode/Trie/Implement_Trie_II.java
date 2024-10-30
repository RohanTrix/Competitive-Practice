class Implement_Trie_II {
    TrieNode root;
    public Implement_Trie_II() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if (next == null) {
                next = new TrieNode();
                curr.children[ch - 'a'] = next;
            }
            curr = next;
        }
        curr.wordEnd++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if(next == null) return 0;
            curr = next;
        }
        return curr.wordEnd;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if(next == null) return 0;
            curr = next;
        }
        return countWordsBelow(curr);
    }
    private int countWordsBelow(TrieNode curr) {
        int childrenCount = 0;
        for(int i = 0; i<26; i++)
            if(curr.children[i]!=null)
                childrenCount+=countWordsBelow(curr.children[i]);
        return curr.wordEnd + childrenCount;
    }

    public void erase(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            TrieNode next = curr.children[ch - 'a'];
            if(next == null) return;
            curr = next;
        }
        curr.wordEnd--;
    }

    static class TrieNode {
        int wordEnd;
        TrieNode children[];

        public TrieNode() {
            this.wordEnd = 0;
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */