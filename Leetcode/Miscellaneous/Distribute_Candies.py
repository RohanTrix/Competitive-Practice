class Solution:
    def distributeCandies(self, can: List[int]) -> int:
        s = set(can)
        if len(s)>len(can)//2:
            return len(can)//2
        return len(s)