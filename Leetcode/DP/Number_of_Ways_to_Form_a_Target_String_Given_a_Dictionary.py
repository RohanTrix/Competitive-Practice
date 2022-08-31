'''
        IDEA : A naive DP implementation will give a O(n3) solution which will TLE.
               
               DP STATE : DP(i,k) =  No. of ways of making target[i...n] when we can currently choose
                                     index at and after `k`
                
               DP TRANSITION : DP(i,k)  = DP(i, k+1)   -----> Not considering kth index fr placing char at i
                                              +
                                    d[(ch,k)]  * DP(i+1,k+1)   ---> For each char ch at kth position, we want to add DP(i+1,k+1) ways
                        
               The main important point to note here is that, at ith index, that we should
               build a count of char `ch` at `ith` index across all words....since this cnt = no.
               of ways of selecting `ch` when we are at ith position....so for each of these occurences,
               we should make a recursive call. But that is just equal to d[(ch,k)] * dp(i+1,k+1)
'''

class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        from collections import defaultdict
        from functools import cache
        d = defaultdict(int)
        for w in words:
            for i,ch in enumerate(w):
                d[(ch,i)]+=1
        
        mod = 10**9+7
        N, wlen = len(target), len(words[0])

        @cache
        def dp(i,k):
            if i == N:
                return 1
            if k == wlen:
                return 0
            
            ch = target[i]
            
            cnt = dp(i, k+1) + d[(ch,k)] * dp(i+1, k+1) 
            
            return cnt % mod
        
        return dp(0,0)
            
            