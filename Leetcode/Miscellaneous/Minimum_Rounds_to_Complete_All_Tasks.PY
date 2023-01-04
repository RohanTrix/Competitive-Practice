# REFER : https://youtu.be/gHR4VTNlVEI

from collections import Counter
class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:

        d = Counter(tasks)
        cnt = 0
        for v in d.values():
            if v == 1:
                return -1
            elif v%3==0:
                cnt+=v//3
            elif v%3==1:
                cnt+=2 + (v-4)//3
            else:
                cnt+=1 + (v-2)//3
        return cnt
        
