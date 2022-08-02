from functools import lru_cache

# IDEA : Adapted from Maximum Product Subarray question.
#        Store both the minimum and maxiumum product in dp[r][c]. Follow code to better understand transitions
class Solution:
    def maxProductPath(self, mat: List[List[int]]) -> int:
        m,n = len(mat), len(mat[0])
        mod = 10**9 + 7
        from functools import lru_cache
        @lru_cache(None)
        def maxProd(r,c):
            # returns [mini, maxi] : The min and max product going from (r,c) to bottom right
            
            if r == m-1 and c == n-1:
                return [mat[r][c], mat[r][c]]
            
            neg, pos = float('inf'), float('-inf')
            val = mat[r][c]
            if r+1 < m:
                neg2, pos2 = maxProd(r+1, c)
                neg = min(neg, neg2 * val, pos2 * val)
                pos = max(pos, neg2 * val, pos2 * val)
            
            if c+1 < n:
                neg2, pos2 = maxProd(r, c+1)
                neg = min(neg, neg2 * val, pos2 * val)
                pos = max(pos, neg2 * val, pos2 * val)
            
            return [neg,pos]
        
        ans = maxProd(0,0)[1] # pos/max value of the product
        return -1 if ans<0 else ans%mod