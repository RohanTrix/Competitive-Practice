class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        # Refer Explanation Link: https://youtu.be/vzjMGYUG7qY
        # Important Problem
        arr.sort()
        n = len(arr)
        dp = [1]*n # As each number will form a treee in itself
        MOD = 10**9+7
        arrSet = set(arr)
        numIndex = {arr[i]:i for i in range(n)}
        for i in range(1,n):
            for j in range(i):
                fact = arr[i]//arr[j];
                if arr[i]%arr[j]==0 and fact in arrSet:
                    dp[i]+= dp[j] * dp[numIndex[fact]]
        
        return sum(dp)%MOD