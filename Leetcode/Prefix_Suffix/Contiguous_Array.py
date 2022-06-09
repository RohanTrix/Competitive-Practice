class Contiguous_Array:
    # REFER : https://youtu.be/1WugaISSWx8
    def findMaxLength(self, nums: List[int]) -> int:
        d = {0:-1}
        s = 0
        bestLen = 0
        nums = list(map(lambda x: -1 if x==0 else 1, nums))
        for i in range(len(nums)):
            s+=nums[i]
            if s not in d.keys():
                d[s] = i
            else:
                bestLen = max(bestLen,i-(d[s]+1)+1)
        return bestLen