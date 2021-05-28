class Solution:
    def firstUniqChar(self, s: str) -> int:
        d = {}
        for i in s:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i]+=1
        
        for i in range(len(s)):
            if d[s[i]]==1:
                return i
        return -1