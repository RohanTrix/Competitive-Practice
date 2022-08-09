class Solution:
    # Read Discuss for IDEA
    # We basically try all possible numbers in range [1..MAX] and check whether it can be a GCD or not.
    # For cand to be a GCD, its multiples should form cand as the GCD


    # For example, suppose we have 4,8...and cand is 2....
    # so we go on multiples of 2 -> 2,4,8...consider ones that are actually present in nums..
    #  -> 4,8...now gcd([4,8]) is 4...and hence 2 cannot be formed...but 4 will get formed...as well as 8
    #  which we will add in the later iterations
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        s = set(nums)
        M = max(nums)
        ans = 0
        for cand in range(1, M+1):
            g = 0
            for mult in range(cand, M+1, cand):
                if mult in s:
                    g = gcd(g, mult)
            if g == cand:
                ans+=1
        return ans