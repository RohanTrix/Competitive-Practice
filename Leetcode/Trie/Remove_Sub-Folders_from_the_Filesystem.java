/* 
        IDEA: the idea is, if we can track whenever we have found a folder, then on traversing the folders,
              we can stop the dfs the first time we find a folder. That way, any folder deeper will not be added to
              the answer. The best way to implement this is a Trie.

              Normally, a Trie is of chars....but here, a folder name can be more than 1 char. So we make a Trie of Strings.
              A TrieNode will have 3 data memeber:

                    1) Map to store a String mapping to TrieNode ...analogous to char mapping to TrieNode using a array
                    2) data = String the current node represents
                    3) folEnd = A folder ends here....analogous to word ending here.

            After we smartly insert the folders into the Trie, we only have to do a DFS search and as soon as
            a valid folder is encountered, we will add to the answer and stop going deeper in dfs(to avoid adding subfolder)
            
            Further explanation in Code

*/

public class Remove_Sub-Folders_from_the_Filesystem {
    static class TrieNode
    {
        int folEnd=0;
        String data;
        Map<String, TrieNode> children = new HashMap<>();
        public TrieNode()
        {
            data = "";
        }
        public TrieNode(String c)
        {
            data= c;
        }
        public void insertString(TrieNode root, String s[])
        {
            // s[] is a array of folder names starting , just the first element is ""
            TrieNode curr = root;
            for(String str : s)
            {
                if(str.length()==0) continue;
                
                // If such a folder is not made yet, we create it.
                if(!curr.children.containsKey(str))
                    curr.children.put(str, new TrieNode(str));
                
                curr = curr.children.get(str); // Make next node current node
            }
            curr.folEnd++; // Mark as a valid folder.
        }

        // Idea is that if we have "/a/bc", "/a/bc/xx"  and "/a"...then during DFS, the first folEnd will be
        // encountered at "/a" and hence we add it to answer and not go deeper for checking the other 2.
        public void dfs(TrieNode root, StringBuilder curr, List<String> res)
        {
            // First folder end found, rest below will be subfolders
            if(root.folEnd>0)
            {
                res.add(curr.toString());
                return;
            }
            
            // To add the next folder to the current folder(for final ans), we need to seperate by "/"
            curr.append('/');
            for(String k : root.children.keySet())
            {
                // Create new folder path and send to dfs
                StringBuilder new_curr = new StringBuilder(curr);
                new_curr.append(k);
                dfs(root.children.get(k),new_curr, res);
                
            }
        }
        
    }
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String s: folder)
        {
            String f[] = s.split("/");
            root.insertString(root, f);
            //System.out.println(Arrays.toString(f));
        }
        root.dfs(root, new StringBuilder(), res);
        return res;
    }
}
