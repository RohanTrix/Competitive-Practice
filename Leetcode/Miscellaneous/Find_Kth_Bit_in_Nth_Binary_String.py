class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        num = [0]
        k-=1
        while(k>=len(num)):
            num.append(1)
            for i in range(len(num)-2, -1, -1):
                num.append(num[i]^1)
        return str(num[k])