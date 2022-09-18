'''
    IDEA : Here we have to think better than traversing O(n^2). The tricky part here is
           to utilise the constraint on the length of each string. We can go to O(n * k^2) which is still
           not a normal constraint on leetcode.

           The idea is to store every string in a hashmap mapped to its index. Now,
           on thinking deeply, a palindrome, if it can be formed, will be formed by having
           a reverse of a prefix at the END....OR...by having a reverse of suffix at the start.

           Now for every word, I take a all the prefixes and suffixes and try to find the concatenated word
           in the hash table
'''


class Solution:
    
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        from collections import defaultdict
        ans = []
        d = defaultdict(int)
        
        for idx,word in enumerate(words):
            d[word] = idx
        
        for i, w in enumerate(words):
            for prefLen in range(len(w)+1):
                
                pref = w[:prefLen]
                other_half = pref[::-1]
                if other_half in d:
                    newWord = w + other_half
                    if(newWord == newWord[::-1]) and i != d[other_half]:
                        ans.append((i, d[other_half]))
                        if other_half == "":
                            ans.append((d[other_half], i))
                suff = w[-prefLen:]
                other_half = suff[::-1]
                if other_half in d:
                    newWord = other_half + w
                    if(newWord == newWord[::-1]) and i != d[other_half]:
                        ans.append((d[other_half], i))
        return list(set(ans))
                
                
                
                