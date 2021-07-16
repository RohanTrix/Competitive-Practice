class Solution:
    # REFER: https://leetcode.com/problems/smallest-range-i/discuss/173367/C++JavaPython-Check-Max-Min/965230
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        maxi, mini = max(nums), min(nums)
        best_diff = (maxi - k) - (mini + k)
        return  best_diff if best_diff>0 else 0