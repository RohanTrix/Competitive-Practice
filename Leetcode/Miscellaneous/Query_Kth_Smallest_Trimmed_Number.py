class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        ans = []
        d = {}
        for k,trim in queries:
            tmp = []
            for i,s in enumerate(nums):
                tmp.append([s[-trim:],i])
            tmp.sort()
            ans.append(tmp[k-1][1])
        return ans

        