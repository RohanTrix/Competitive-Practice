package Leetcode.Trie;

/**
 *      IDEA : Each TrieNode stores a list of indexes which corresponds to the words in the products array. The list
 *             contains at most 3 lexicographically smallest strings which lie in the subtree of this current node. 
 */

public class Search_Suggestions_System {
    class TrieNode
    {
        char data;
        TrieNode children[] = new TrieNode[26];
        boolean wordEnd;
        List<Integer> idxs;
        public TrieNode(char ch)
        {
            this.data = data;
            wordEnd = false;
            idxs = new ArrayList<>();
        }
        public void insertString(TrieNode root,String s, int i)
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
                if(curr.idxs.size()<3)
                    curr.idxs.add(i);
            }
            curr.wordEnd = true;
        }
        public void suggestionBuilder(TrieNode root, String query, List<List<String>> res, String products[])
        {
            TrieNode curr = root;
            for(char ch : query.toCharArray())
            {
                List<String> tmp = new ArrayList<>();
                if(curr == null)
                {
                    res.add(tmp);
                    continue;
                }
                TrieNode next = curr.children[ch-'a'];
                if(next != null)
                {
                    for(int ind : next.idxs)
                        tmp.add(products[ind]);
                }
                res.add(tmp);
                curr = next;
            }
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode('\0');
        for(int i = 0; i<products.length; i++)
        {
            root.insertString(root, products[i], i);
        }
        List<List<String>> res = new ArrayList<>();
        root.suggestionBuilder(root, searchWord, res, products);
        return res;
    }
}
