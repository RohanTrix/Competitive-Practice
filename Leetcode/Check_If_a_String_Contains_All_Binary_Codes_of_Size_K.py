class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool: #(NAIVE APPROACH) (ACCEPTED)
        #Algorithm:
        # For a value k, there will be 2^k binary strings of length k
        # Since we only need to check the k length substrings...we put al the substrings in a set
        # and check if the length is equal to 2^k
        # Note: 2^k can be written as 1<<k
        n = len(s)
        con = set() #container of subtrings of length k
        for i in range(n-k+1):
            sub = s[i:i+k]
            con.add(sub)
        return 1<<k == len(con)
    