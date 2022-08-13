class Solution:
    def numTimesAllBlue(self, flips: List[int]) -> int:
        # IDEA : If the count of SET bits at any moment is EQUAL to the maximum bit that is set...then that moment is pref-aligned
        setBits = maxSetBit = ans = 0
        for bit in flips:
            setBits+=1
            maxSetBit = max(maxSetBit, bit)
            if maxSetBit == setBits:
                ans+=1
        return ans