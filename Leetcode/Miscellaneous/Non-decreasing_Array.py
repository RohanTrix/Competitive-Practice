class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        found = False
        n = len(nums)
        for i in range(1, n):
            if nums[i]<nums[i-1]:
                if found:
                    return False
                if i>=2 and nums[i]<nums[i-2]:
                    nums[i] = nums[i-1]
                else:
                    nums[i-1] = nums[i]
                found  = True
        return True