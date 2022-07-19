'''
        # REFER : https://youtu.be/BUe_dxsRQa4
        IDEA : Choose 2 starting points in s and t as st1 and st2...This will take O(n2).
               Now we will start building substrings from these starting points(until we can..i.e either string 
               ends)....We basically want to count the following substrings

                    st1
                    st2     i         j
                s = _ _ _ _ a _ _ _ _ a
                t = _ _ _ _ b _ _ _ _ b

                Assuming _ represent same chars in both strings, we want to count substrings
                BETWEEN i (where the first difference) occurs to (j-1) where j is the second difference
                Traversing both strings together will take O(n) and hence total complexity is O(n3)

'''

class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        ls, lt = len(s), len(t)
        cnt = 0
        for st1 in range(len(s)):
            for st2 in range(len(t)):
                i,j = st1, st2
                diff = 0
                while(i < ls and j < lt):
                    if s[i] != t[j]:
                        diff+=1
                    if diff == 1:
                        cnt+=1
                    elif diff == 2:
                        break
                    i+=1
                    j+=1
        return cnt
                    