class Solution:
    # IDEA : O(N^3) brute force idea....
    # Can be solve in O(n^2) using Trie similar to this : https://leetcode.com/problems/words-within-two-edits-of-dictionary/discuss/2756369/Trie-vs.-Hamming-Distance
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        ans = []
        for word in queries:
            for dword in dictionary:
                c = 0
                for ch1, ch2 in zip(word, dword):
                    if ch1!=ch2:
                        c+=1
                if c<=2:
                    ans.append(word)
                    break
        return ans