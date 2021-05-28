class Solution:
    # REFER : https://youtu.be/eDtMmysldaw
    def splitString(self, s: str) -> bool:
        def dfs(index, prev):
            if index == len(s):
                return True

            for j in range(index, len(s)):
                val = int(s[index:j+1])
                if prev - val==1 and dfs(j+1,val):
                    return True
            return False
        for i in range(len(s) -1):
            val = int(s[:i+1])
            if dfs(i+1, val):
                return True
        return False