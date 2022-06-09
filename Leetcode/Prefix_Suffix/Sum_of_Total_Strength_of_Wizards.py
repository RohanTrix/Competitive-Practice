from itertools import accumulate 
class Solution:

    # REFER : https://youtu.be/HYCMvFxWO7w

    # My explanation : Explained in OneNote
    def totalStrength(self, nums: List[int]) -> int:
        stack = []
        mod = 10**9+7
        n = len(nums)
        firstSmallerToLeft = [-1 for i in range(n)]
        firstSmallerToRight = [-1 for i in range(n)]
        for i in range(n):
            while stack and nums[stack[-1]] > nums[i]:
                stack.pop()
            if stack:
                firstSmallerToLeft[i] = stack[-1]
            stack.append(i)
        
        stack = []
        for i in range(n):
            while stack and nums[stack[-1]] > nums[i]:
                firstSmallerToRight[stack.pop()] = i
            stack.append(i)
        
        pref = list(accumulate(nums, initial = 0))
        prefSum = [0 for i in range(n+1)]
        for i in range(1, n+1):
            prefSum[i] = (prefSum[i-1] + pref[i])
        
        res = 0
        for i in range(n):
            leftBound = firstSmallerToLeft[i]+1
            rightBound = n-1 if firstSmallerToRight[i]==-1 else firstSmallerToRight[i]-1
            
            part1 = (i-leftBound+1)*(prefSum[rightBound+1]-prefSum[i+1-1])
            
            part2 = (rightBound-i+1)*(prefSum[i+1-1] - prefSum[0 if leftBound-1<0 else leftBound-1])
            
            diff = part1 - part2
            res+=(diff*nums[i])
            res%=mod
        return res