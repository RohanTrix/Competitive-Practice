class Solution:
    
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        dr = [1,0,-1,0]
        dc = [0,1,0,-1]
        mod = 10**9 +7

        @lru_cache(None)
        def dfs(M, N, r, c, movesLeft):
            if r<0 or r>=M or c<0 or c>=N:
                return 1
            if movesLeft==0:
                return 0

            res = 0
            for i in range(4):
                res+=dfs(M,N,r+dr[i], c+dc[i], movesLeft-1)%mod
            return res%mod
        
        return dfs(m,n,startRow, startColumn,maxMove)
        