class Solution:
    def countBalls(self, low: int, high: int) -> int:
        def digitSum(x):
            s = 0
            while(x>0):
                d = x%10
                s+=d
                x//=10
            return s
        d = {}
        for i in range(low,high+1):
            s = digitSum(i)
            if s not in d.keys():
                d[s]=1
            else:
                d[s]+=1
        
        return max(d.values())