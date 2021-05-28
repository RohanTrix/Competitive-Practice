class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        l = []
        for i, v in enumerate(nums):
            if v==target:
                l.append(i)
        mini = 9999999999
        for i in l:
            mini = min(mini, abs(i-start))
        return mini