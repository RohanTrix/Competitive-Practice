class Solution:
    def queryString(self, s: str, n: int) -> bool:
        
        for num in range(1, n+1):
            binrep = bin(num)[2:]
            if binrep not in s: return False
        return True