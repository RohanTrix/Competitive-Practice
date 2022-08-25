class Solution:
    # rearrange eqn to get i's on one side and j's on one side...then its just a counting problem
    def countNicePairs(self, nums) -> int:
        from collections import Counter
        d = Counter()
        for num in nums:
            v = num - int(str(num)[::-1])
            d[v]+=1
        ans = 0
        for v in d.values():
            ans+=(v*(v-1))//2
        return ans % (10**9+7)