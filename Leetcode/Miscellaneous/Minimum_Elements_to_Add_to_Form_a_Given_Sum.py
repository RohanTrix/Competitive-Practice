class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        s = sum(nums)
        amt = abs(goal-s)
        limit = abs(limit)
        return (amt+limit-1)//limit # Taking Ceil