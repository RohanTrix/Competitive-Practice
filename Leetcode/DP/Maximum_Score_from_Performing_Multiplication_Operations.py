from functools import lru_cache

class Solution:
    def maximumScore(self, nums: List[int], mul: List[int]) -> int:
        
        @lru_cache(maxsize = None)
        def maxScore(i,m):
            j = len(nums)-1 + (i - m)
            if m==len(mul): return 0
            
            a = nums[i]*mul[m] + maxScore(i+1,m+1)
            b = nums[j]*mul[m] + maxScore(i,m+1)
            return max(a,b)
        
        return maxScore(0,0);