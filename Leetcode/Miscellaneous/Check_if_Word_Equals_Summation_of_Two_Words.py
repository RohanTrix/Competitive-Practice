class Solution:
    def isSumEqual(self, f: str, s: str, t: str) -> bool:
        def calc(x):
            c = ''
            for i in x:
                c+=str(ord(i) - 97)
            return int(c)
        return calc(f) + calc(s) == calc(t)