class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        s = set()
        n = len(nums)
        rep = 0
        for i in range(n):
            if nums[i]  in s:
                rep = nums[i]             
            else:
                s.add(nums[i])
        fs = n*(n+1)//2
        fs = fs - (sum(nums) - rep)
        return [rep,fs]