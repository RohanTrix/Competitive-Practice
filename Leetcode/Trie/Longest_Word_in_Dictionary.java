package Leetcode.Trie;

/*
    IDEA : We want the longest word for which each prefix is present in the array. On drawing a Trie
           for an example, it is easy to see that we want to do a DFS(to find longest).
           
        - wordEnd parameter marks that a word ends here or not.

        After making the Trie, we do a DFS from root node. We only go down on  a node if 
            1. It is not null
            2. The node we are going to has a wordEnd>0 meaning a word ends there. 

            By doing 2. we can ensure we only go down if there is a successively building prefix.

            At each dfs's end, we just update our string if it is longer than the longest word. stored currently.
*/

public class Longest_Word_in_Dictionary {
    static class TrieNode
    {
        char data = '\0';
        TrieNode children[] = new TrieNode[26];
        int wordEnd;
        String longest = "";
        public TrieNode(char c)
        {
            data =c;
        }
        public void insertString(String s, TrieNode root)
        {
            TrieNode curr = root;
            
            for(char ch : s.toCharArray())
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
        public void dfs(TrieNode root, String s)
        {
            
            for(int i = 0; i<26; i++)
            {
                TrieNode next = root.children[i];
                if(next != null && next.wordEnd>0)
                {
                    //System.out.println((char)(i+'a'));
                    dfs(next, s+((char)(i+'a')));
                }
            }
            if(s.length()>longest.length())
                longest = s;
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode('a');
        for(String word : words) root.insertString(word, root);
        root.dfs(root, "");
        return root.longest;
    }
}
