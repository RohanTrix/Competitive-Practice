class Solution:
    # Brute Force
    # REFER : https://youtu.be/S_WnsW5cdgI
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        seen  = set()
        seen.add(s)
        
        stack = [s]
        n = len(s)
        ans = '9'*n # basically INTMAX for us
        
        
        while stack:
            curr = stack.pop()
            ans = min(ans, curr)
            s_list = list(curr)
            
            # Operation 1
            
            for i in range(1, n, 2):
                c = s_list[i]
                new_c = str((ord(c) - ord('0') + a)%10)
                s_list[i] = new_c
                
            new_s = ''.join(s_list)
            
            if new_s not in seen:
                stack.append(new_s)
                seen.add(new_s)
                
            # Operation 2
            
            new_s = curr[n-b:] + curr[:n-b]
            if new_s not in seen:
                stack.append(new_s)
                seen.add(new_s)
        return ans