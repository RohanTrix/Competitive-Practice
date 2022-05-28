/**
 *      IDEA : Since we have a lot of words, we can dump them in a Trie which has a wordEnd parameter denoting whether
 *             or not a word ends here. Finally, we do a backtracking approach on the grid starting from each cell
 *             and we also keep going deep in the Trie. Basically, we take the edge in the trie same as the next cell's 
 *             letter. Also, as soon as we reach a node with wordEnd = TRUE, we add it to our answer set. To improvise, we remove
 *             this word from the Trie since it has been added to our answer and need not be considered again.
 */

public class Word_Search_II {
    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};
    TrieNode mainRoot;
    Set<String> set = new HashSet<>();
    public void dfs(int x, int y, char board[][], TrieNode root, StringBuilder curr)
    {
        if(root.wordEnd)
        {
            set.add(curr.toString());
            mainRoot.removeString(mainRoot, curr.toString());
        }
        char original = board[x][y];
        board[x][y] = '#';
        for(int p = 0; p<4;p++)
        {
            int nx = x+dr[p], ny = y+dc[p];
            
            if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length || board[nx][ny] == '#') continue;
            TrieNode next = root.children[board[nx][ny]-'a'];
            if(next == null) continue;
            curr.append(board[nx][ny]);
            dfs(nx,ny, board, next,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        board[x][y] = original;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        mainRoot = root;
        for(String word : words)
            root.insertString(root, word);
        
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                TrieNode next = root.children[board[i][j]-'a'];
                s.append(board[i][j]);
                if(next!=null)
                    dfs(i,j,board, next, s);
                s.deleteCharAt(0);
            }
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }
    
    static class TrieNode
    {
        char data; int pref = 0;
        TrieNode children[] = new TrieNode[26];
        boolean wordEnd;
        public TrieNode(char c)
        {
            this.data = c;
        }
        public TrieNode()
        {
            this.data = '\0';
        }
        public void insertString(TrieNode root, String s)
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
                next.pref++;
                curr = next;
            }
            curr.wordEnd = true;
        }
        public void removeString(TrieNode root, String s)
        {
            TrieNode curr = root;
            for(char ch : s.toCharArray())
            {
                TrieNode next = curr.children[ch-'a'];
                
                if(next == null || next.pref == 1)
                {
                    next = null;
                    curr.children[ch-'a'] = next;
                    break;
                }
                curr = next;
            }
        }
    }
}