class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = []
        prefix = []
        su=0
        for i in range(n):
            su+=nums[i]
            prefix.append(su)
        #print(prefix)
        for i in range(n):
            before = i
            after = n-1-i
            p1 = 0
            p2 = 0
            if before==0:
                ans.append(prefix[n-1]-prefix[0] - (after*nums[i]))
            elif after == 0:
                ans.append((before*nums[i])-prefix[n-2])
            else:
                ans.append((before*nums[i]) -prefix[i-1] + (prefix[n-1]-prefix[i]) - after*nums[i])
        return ans