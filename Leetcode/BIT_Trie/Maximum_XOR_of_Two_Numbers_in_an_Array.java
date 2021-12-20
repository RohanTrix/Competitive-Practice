package Leetcode.BIT_Trie;

/*          IDEA: This problem uses Bit Trie. If that concept is clear,
            then first we sort:

                1) nums array...so that when we process the ith element, we only find
                                what is its counterpart for getting a MAX Xor value
                                
            For each element in nums:
                    To understand how to find the value with
                    which to xor, REFER Algo Zentih - Bit Trie Applications video

*/

public class Maximum_XOR_of_Two_Numbers_in_an_Array {
    static class TrieNode {
        int data;
        TrieNode children[] = new TrieNode[2];

        public TrieNode() {
            data = -1;
        }

        public TrieNode(int data) {
            this.data = data;
        }

        public void insertNum(TrieNode root, int n) {
            TrieNode curr = root;

            for (int i = 31 - 1; i >= 0; i--) {
                int nextBit = (n & (1 << i)) != 0 ? 1 : 0;
                TrieNode next = curr.children[nextBit];
                if (next == null) {
                    next = new TrieNode(nextBit);
                    curr.children[nextBit] = next;
                }
                curr = next;
            }
            curr.data = n;
        }

        public int query_max_xor(TrieNode root, int n) {
            TrieNode curr = root;

            for (int i = 31 - 1; i >= 0; i--) {
                int nextBit = (n & (1 << i)) != 0 ? 1 : 0;
                TrieNode next = curr.children[1 ^ nextBit];
                if (next != null)
                    curr = next;
                else
                    curr = curr.children[nextBit];
            }
            return curr.data;
        }
    }

    public int findMaximumXOR(int[] nums) {
        int xor = 0;
        Arrays.sort(nums);
        TrieNode root = new TrieNode();
        for (int i = 0; i < nums.length; i++) {
            root.insertNum(root, nums[i]);
            xor = Math.max(xor, nums[i] ^ root.query_max_xor(root, nums[i]));
        }
        return xor;
    }
}
