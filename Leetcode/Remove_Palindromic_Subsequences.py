class Solution:
    def removePalindromeSub(self, s: str) -> int:
        se = set(s)       
        if s=="":
            return 0
        if s==s[::-1]:
            return 1
        return len(se)
        