class Solution:
    def hammingWeight(self, n: int) -> int:
        s = bin(n)[2:]
        cnt = 0
        for i in s:
            if i=='1':
                cnt+=1
        return cnt