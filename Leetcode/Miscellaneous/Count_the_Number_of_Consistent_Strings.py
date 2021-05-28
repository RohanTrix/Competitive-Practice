class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        cnt = 0
        for i in words:
            b = True
            for ch in i:
                if ch not in allowed:
                    b =False
            if b:
                cnt+=1
        return cnt;