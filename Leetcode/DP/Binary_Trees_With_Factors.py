from functools import lru_cache
class Solution:
    '''
        IDEA : You need to try to make every element the root and then recursively calculate
               the count of ways for making left subtree and rightsubtree....and multiply them to 
               make all combinations.

               Main observation : Suppose you place 10 at the root, now try to place a number
                                  from the set as the root of leftSubtree and correspondingly
                                  rightsubtree

                                  The key observation is for a given node, we should store all possible
                                  trees count since this no. can be a factor for other numbers as well
                                  and we can avoid repeated work using DP
    '''
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        mod = 10**9+7
        nums = set(arr)

        @lru_cache(None)
        def count(root):
            if root not in nums:
                return 0
            c = 1
            
            for left in nums:
                if root%left == 0 and root!=left:
                    leftCount = count(left)
                    rightCount = count(root//left)
                    v=leftCount*rightCount
                    c+=v
            return c%mod
        
        ans = 0
        for val in nums:
            ans+=count(val)
            ans%=mod
        return ans

    
class Solution1:
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