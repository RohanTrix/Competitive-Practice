// package DSA.String;
public class Main
{
    static class TrieNode
    {
        char data;
        TrieNode children[] = new TrieNode[128];
        int wordEnd;
        int prefix;
        public TrieNode()
        {
            data ='\0';
            wordEnd = 0;
        }
        public TrieNode(char data)
        {
            this.data = data; 
        }
        public void insertString(TrieNode root, String s)
        {
            TrieNode curr = root;
            for (char ch : s.toCharArray()) {
                TrieNode next = curr.children[ch];
                if(next == null)
                {
                    next = new TrieNode(ch);
                    curr.children[ch] = next;
                }
                curr = next;
            }
            curr.wordEnd++;
        }
        public boolean searchWord(TrieNode root, String word)
        {
            TrieNode v = root;
            for(char ch : word.toCharArray())
            {
                TrieNode next = v.children[ch];
                if(next==null)
                    return false;
                v = next;
            }
            return v.wordEnd>0;
        }
        public boolean checkPrefixExists(TrieNode root,String p)
        {
            TrieNode v = root;
            for(char ch : p.toCharArray())
            {
                TrieNode next = v.children[ch];
                if(next==null)
                    return false;
                v = next;
            }
            return true;
        }
    }
    public static void main(String args[])
    {
        TrieNode root = new TrieNode();
        root.insertString(root, "hello");
        root.insertString(root, "hell");
        root.insertString(root, "how");
        root.insertString(root, "bored");
        System.out.println(root.checkPrefixExists(root, "hep"));
    }
}