class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n = len(s)
        s1 = s[:n//2]
        s2 = s[n//2:]
        c1 = c2 = 0
        for i in s1.lower():
            if i in "aeiou":
                c1+=1
        for i in s2.lower():
            if i in "aeiou":
                c2+=1
        return c1==c2
    