'''
The dp value at any position in the matrix is sum of paths coming from above it(if cell exists)
and to the left of it(if cell exists).
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for j in range(n)] for i in range(m)]
        dp[0][0] = 1
        
        for i in range(m):
            for j in range(n):
                if i==0 and j==0: continue
                
                if(j-1>=0):
                    dp[i][j]+=dp[i][j-1]
                if(i-1>=0):
                    dp[i][j]+=dp[i-1][j]
        return dp[m-1][n-1]
