'''
        NOTE : MODDING ISSUES FACED WHICH ARE TOUGH TO SOLVE IN JAVA

        IDEA : At any index, we basically have 2 choices...either continue on the same path
               OR jump to the other array IF the currVal is also present there. Now, using 2 pointers
               we would have to store dp[i][j][side]...but storing both i and j will MLE and TLE.
               Rather, we already have a variable `side` ...which can be used to denote the answer
               for ith index for either subarray(side is a binary variable).

               So finally, OUR DP STATE : dp[i][side] = Max path sum starting from ith cell of `side` array.

               There is one issue : How to know whether we can jump from current or not without keeping
               a 2nd pointer j....SOLUTION -> Build and val-> idx map for both arrays.
               We jump to the other array if the val->idx map of that array contains the currVal.
               NOTE : Jump to the index just after the index of currVal since otherwise it would get
               stuck in infinite recursion
'''
import sys
sys.setrecursionlimit(10**7) 
class Solution:
    def maxSum(self, nums1: List[int], nums2: List[int]) -> int:
        n1,n2 = len(nums1), len(nums2)
        dp = {}
        idx1 = {v:i for i,v in enumerate(nums1)}
        idx2 = {v:i for i,v in enumerate(nums2)}
        mod = 10**9 + 7
        
        @lru_cache(None)
        def maxScore(ind, side):
            if side == 0 and ind == n1: return 0
            if side == 1 and ind == n2: return 0
            
            currVal = nums1[ind] if side == 0 else nums2[ind]
            samePath = maxScore(ind+1, side)
            changePath = 0
            if side == 0 and currVal in idx2:
                changePath = maxScore(idx2[currVal]+1, side^1)
            if side == 1 and currVal in idx1:
                changePath = maxScore(idx1[currVal]+1, side^1)
            
            ans = max(samePath, changePath)+currVal
            return ans
        
        return max(maxScore(0,0), maxScore(0,1))%mod