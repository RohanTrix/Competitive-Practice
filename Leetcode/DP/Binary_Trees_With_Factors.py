class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        # Refer Explanation Link: https://youtu.be/vzjMGYUG7qY
        # Important Problem
        arr.sort()
        n = len(arr)
        dp = [1]*n # As each number will form a treee in itself
        MOD = 10**9+7
        arrSet = set(arr)
        numIndex = {arr[i]:i for i in range(n)} # Maps the value in the array to its index
        for i in range(1,n):
            for j in range(i):
                fact = arr[i]//arr[j];
                if arr[i]%arr[j]==0 and fact in arrSet:
                    dp[i]+= dp[j] * dp[numIndex[fact]]  # Since if u fix left side of the tree ..you can make n different trees if there
                                                        # n different ways of making right subtree. Thus for m such left subtrees, you can make
                                                        # m * n different trees
        
        return sum(dp)%MOD # The sum of all the trees you can make is the answer