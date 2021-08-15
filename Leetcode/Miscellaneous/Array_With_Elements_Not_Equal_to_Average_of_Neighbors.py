class Solution:
    '''
    We know median of the sorted array is the middle value. So if we place a element
    (whise value is more than median) between 2 elements (whose value is less than median),
    the we can ensure that the average will always be less than the middle value.

    '''
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        nums.sort()
        med = 0
        n = len(nums)
        
        ans = []
        for i in range(n//2):
            ans.append(nums[i])
            ans.append(nums[n-i-1])
        if(n%2!=0):
            ans.append(nums[n//2])
        
        return ans