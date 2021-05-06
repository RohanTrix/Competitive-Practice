class Solution:
    def climbStairs(self, n: int) -> int:
        dp = []
        if n==1: return 1
        dp.append(1)
        dp.append(1)
        for i in range(2,n+1):
            dp.append(dp[i-1]+ dp[i-2])
        return dp[n]