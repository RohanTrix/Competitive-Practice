class Solution:
    def numberOfWays(self, startPos: int, endPos: int, k: int) -> int:
        
        from functools import cache
        mod = 10**9 + 7
        @cache
        def dp(pos, k):
            if k == 0:
                return 1 if pos == endPos else 0
            
            return dp(pos+1, k-1) + dp(pos-1,k-1)
        
        return dp(startPos, k) % mod