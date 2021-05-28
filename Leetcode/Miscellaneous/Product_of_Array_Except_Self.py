class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left, right = [],[0 for i in range(n)]
        for i in range(n):
            if(i==0):
                left.append(nums[i])
            else:
                left.append(nums[i]*left[i-1])
        for i in range(n-1,-1,-1):
            if(i==n-1):
                right[i] = nums[i]
            else:
                right[i]=nums[i]*right[i+1]
        print(left, right)
        ans = [1 for i in range(n)]
        for i in range(1,n):
            ans[i] = left[i-1]
        for i in range(n-1):
            ans[i]*=right[i+1]
        return ans