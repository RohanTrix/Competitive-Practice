class Solution:
    # We start tracing the line from a point...so we need to maintain whether we are extending a line or not using the tracing
    # parameter. We have 2 options at a point
    #       1) We can skip this point....if line is being traced, it will keep tracing, if not being traced, we won't start from here
    #       2) We can either start a line or end a line here based on whether we are already tracing or not
    # 
    #               So if NOT tracing, we can start line at ith point.
    #               If TRACING, then we call count(i, 0, k-1) denoting we have consumed 1 line by ending it here, not tracing anymore,
    #               and next choice of starting a new line or not can be taken at current point itself
    def numberOfSets(self, n: int, K: int) -> int:
        
        @cache
        def count(i, tracing, k):
            if k<0:
                return 0
            if i == n:
                if k == 0 and tracing == 0:
                    return 1
                return 0
            
            ans = 0
            # skip current point --- if tracing, continue tracing, if not...then just simply skip
            ans+=count(i+1, tracing, k)
            
            if tracing == 0:
                #start line here
                ans+=count(i+1, 1, k)
            else:
                #
                ans+=count(i, 0, k-1)
            
            return ans
        
        mod = 10**9 + 7
        return count(0,0,K) % mod
            
            