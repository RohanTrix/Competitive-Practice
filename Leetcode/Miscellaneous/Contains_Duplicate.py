class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        d = defaultdict(int)
        for i in nums:
            d[i]+=1
        return True if max(d.values())>1 else False