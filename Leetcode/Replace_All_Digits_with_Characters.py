class Solution:
    def replaceDigits(self, s: str) -> str:
        n = len(s)
        l = list(s)
        for i in range(1,n,2):
            num = int(s[i])
            l[i] = chr(ord(s[i-1])+num)
        return ''.join(l)