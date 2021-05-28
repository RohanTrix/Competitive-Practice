class Max_Number_of_K_Sum_Pairs:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        i=0
        j=n-1
        cnt = 0
        while(i<j):
            if k-nums[i]<nums[j]:
                j-=1
            elif k-nums[j]>nums[i]:
                i+=1
            else:
                cnt+=1
                i+=1
                j-=1
        return cnt
            