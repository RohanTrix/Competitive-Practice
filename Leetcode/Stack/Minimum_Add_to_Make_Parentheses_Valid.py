class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        # c = Count of unmatched opening '(' brackets
        # ans = Count of unmatched closing ')' brackets
        # If opening bracket found, we increase counter by one and if decreasing found, we decrease counter by 1
        # If c<0..then we just found an unmatched closing bracket....so we add 1 to the ans and reset c = 0

        #  Final answer = ans + cnt = Count of unmatched closing bracket + Count of unmatched opening brackets
        ans, c = 0,0
        for ch in s:
            if ch == '(':
                c+=1
            else:
                c-=1
            if c<0:
                ans+=1
                c = 0
        return ans + c