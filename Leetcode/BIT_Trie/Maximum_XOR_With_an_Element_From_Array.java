package Leetcode.BIT_Trie;

/*          IDEA: This problem uses Bit Trie. If that concept is clear,
            then first we sort:

                1) queries array on m value....then we only need to add elements from nums to the Trie 
                                               which are less than mi
                2) nums array...so that when we process the ith query, only the elements <= mi are
                                added to Trie
                                
            For each query in sorted(queries):
                    We traverse the sorted nums uptil nums[i] <= mi and add these to the Trie.
                    
                    Once all permitted elements are added, we simply find the best value which
                    on Xoring with the given value wud be MAX. To understand how to find the value with
                    which to xor, REFER Algo Zentih - Bit Trie Applications video

*/

public class Maximum_XOR_With_an_Element_From_Array {
    static class TrieNode
    {
        int data;
        TrieNode children[] = new TrieNode[2];
        int prefix;
        public TrieNode()
        {
            data =-1;
            prefix = 0;
        }
        public TrieNode(int data)
        {
            this.data = data; 
            this.prefix = 0;
        }
        public void insertNum(TrieNode root, int n)
        {
            TrieNode curr = root;
            for(int i = 31-1; i>=0; i--)
            {
                curr.prefix++;
                int nextBit = (n&(1<<i))!=0?1:0;
                TrieNode next = curr.children[nextBit];
                if(next == null)
                {
                    next = new TrieNode(nextBit);
                    curr.children[nextBit] = next;
                }
                curr = next;
            }
            curr.data = n;
        }
        public int query_max_xor(TrieNode root, int n)
        {
            TrieNode curr = root;
            int ans = 0;
            for(int i = 31-1; i>=0; i--)
            {
                int nextBit = (n&(1<<i))!=0?1:0;
                TrieNode next = curr.children[1^nextBit];
                if(next!=null)
                    curr = next;
                else
                    curr = curr.children[nextBit];
            }
            return curr.data;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        
        HashMap<int[], Integer> mp_to_idx = new HashMap<>();
        int p = 0;
        for(int[] q: queries) mp_to_idx.put(q, p++);
        
        Arrays.sort(queries, (a,b) -> Integer.compare(a[1],b[1]));
        Arrays.sort(nums);
        int res[] = new int[queries.length];
        Arrays.fill(res, -1);
        
        TrieNode root = new TrieNode();
        int i = 0;
        for(int[] q: queries)
        {
            int x = q[0];
            int m = q[1];
            
            while(i<nums.length && nums[i] <= m)
            {
                //System.out.println(nums[i]+" ");
                root.insertNum(root, nums[i]);
                i++;
            }
            
            if(i==0)continue;
            res[mp_to_idx.get(q)] = x^root.query_max_xor(root,x);
        }
        
        return res;
    }
}
