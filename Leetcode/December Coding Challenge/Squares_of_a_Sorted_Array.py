class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        nums = sorted(list(map(abs,nums)))
        return [i*i for i in nums]