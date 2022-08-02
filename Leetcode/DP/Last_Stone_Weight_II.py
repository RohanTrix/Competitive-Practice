'''
    TRICKY QUESTION....THIS OBSERVATION IS NEEDED
    LOGIC : https://leetcode.com/problems/last-stone-weight-ii/discuss/672906/Explanation:-Why-Problem-is-Knapsack/599670

    IDEA : So I wrote a recursive DP solution such that dp[i][s] = T/F if it is possible to make sum=s from picking
           some elements in stones[0...i]

           Next, we basically want to maximise set2 as shown in Editorials..I traverse back from fullSum/2 and
           take the first(highest) sum that set2 can become....Now we know the sum of both sets and we just return the absolute diff
           of the 2

'''
class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        from functools import lru_cache
        fullSum = sum(stones)
        n = len(stones)
        @lru_cache(None)
        def possible(i, s):
            if i == -1:
                return True if s==0 else False
            return possible(i-1, s) or possible(i-1, s-stones[i])
        
        for s in range(fullSum//2, -1, -1):
            if possible(n-1, s):
                return abs(s - (fullSum-s))