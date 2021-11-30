from collections
from typing import Counter
class Construct_K_Palindrome_Strings:
    def canConstruct(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False
        
        d = Counter(s)
        odd_cnt = 0
        for i in d:
            if d[i]%2!=0:
                odd_cnt+=1
        if odd_cnt>k:
            return False
        return True