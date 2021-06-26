class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        for i in range(n-2):
            left = i+1
            right = n-1
            while(left<right):
                s = nums[i]+nums[left]+nums[right]
                if(s==0):
                    if [nums[i], nums[left],nums[right]] not in ans:
                        ans.append([nums[i], nums[left],nums[right]])
                    left+=1
                elif(s>0):
                    right-=1;
                else:
                    left+=1;
        return ans