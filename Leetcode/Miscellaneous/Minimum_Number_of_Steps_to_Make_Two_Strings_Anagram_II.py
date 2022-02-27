class Solution:
    def minSteps(self, s: str, t: str) -> int:
        d = Counter()
        for i in s:
            d[i]+=1
        for i in t:
            d[i]-=1
        
        #print(d)
        cnt = 0
        for i in d.values():
            cnt+=abs(i)
        return cnt
        