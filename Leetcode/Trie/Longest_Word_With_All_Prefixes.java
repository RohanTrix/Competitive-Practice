public class Longest_Word_With_All_Prefixes {
    static class TrieNode {
        boolean wordEnd;
        TrieNode children[];
        public TrieNode() {
            this.children = new TrieNode[26];
            this.wordEnd = false;
        }
        public void addWord(TrieNode root, String word) {
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                TrieNode next = curr.children[ch - 'a'];
                if(next == null) {
                    next = new TrieNode();
                    curr.children[ch - 'a'] = next;
                }
                curr = next;
            }
            curr.wordEnd = true;
        }
        public boolean isAllPrefixesPresent(TrieNode root, String word) {
            TrieNode curr = root;
            boolean ans = true;
            for(char ch : word.toCharArray()) {
                TrieNode next = curr.children[ch - 'a'];
                ans = ans && next.wordEnd;
                curr = next;
            }
            return ans;
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words)
            root.addWord(root, word);

        Arrays.sort(words);
        int maxLen = 0;
        String ans = "";
        for(String word : words)
            if(word.length() > maxLen && root.isAllPrefixesPresent(root, word)) {
                maxLen = word.length();
                ans = word;
            }
        return ans;

    }
}