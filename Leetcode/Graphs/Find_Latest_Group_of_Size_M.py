
class UF:
    def __init__(self, n, m):
        self.p = [i for i in range(n+1)]  # parent for each position
        self.c = [0 for _ in range(n+1)]  # length of group for each position
        self.m_cnt = 0                    # count of group with length m
        self.m = m                        # m
        
    def union(self, i, j):
        pi, pj = self.find(i), self.find(j)
        if pi != pj:
            if self.c[pi] == self.m: self.m_cnt -= 1  # if previous length at pi is m, decrement m_cnt by 1
            if self.c[pj] == self.m: self.m_cnt -= 1  # if previous length at pj is m, decrement m_cnt by 1
            self.p[pj] = pi                           # union, use pi at parent for pj
            self.c[pi] += self.c[pj]                  # update new length at pi
            if self.c[pi] == self.m: self.m_cnt += 1  # if new length at pi == m, increment m_cnt by 1
            
    def mark(self, i):                                
        self.c[i] = 1                                 # when first visit a point, mark length as 1
        if self.m == 1: self.m_cnt += 1               # if self.m == 1, increment m_cnt by 1
        
    def find(self, i):                                # find parent of i
        if self.p[i] != i:
            self.p[i] = self.find(self.p[i])
        return self.p[i]
    
class Solution:
    def findLatestStep(self, arr: List[int], m: int) -> int:
        n = len(arr)
        uf, ans = UF(n, m), -1                                   # create union find and answer
        for i, num in enumerate(arr, 1):
            uf.mark(num)
            if num-1 >= 1 and uf.c[num-1]: uf.union(num-1, num)  # if left neighbor is marked, union the two
            if num+1 < n+1 and uf.c[num+1]: uf.union(num+1, num) # if right neighbor is marked, union the two
                
            if uf.m_cnt > 0: ans = i                             # if m_cnt > 0, meaning there exists some group with length m, update ans
        return ans