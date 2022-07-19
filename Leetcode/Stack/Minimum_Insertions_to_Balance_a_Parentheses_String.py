class Solution:
    # DIFFICULT PROBLEM
    # IDEA : ALEX WICE INTERVIEW WEEKLY 9
    def minInsertions(self, s: str) -> int:
        ans = balance = 0
        for ch in s:
            if ch == '(':
                balance+=2
                if balance%2==1:
                    balance-=1
                    ans+=1
            else:
                balance-=1
            if balance < 0:
                ans+=1
                balance+=2
        return ans + balance
