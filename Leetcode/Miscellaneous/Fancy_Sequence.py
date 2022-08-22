mod = (10 ** 9 + 7)
class Fancy(object):
    # REFER ALEX WICE - https://youtu.be/KFPZzHd8fh8
    def __init__(self):
        self.A = []
        self.add = [0]
        self.mul = [1]

    def append(self, a):
        self.A.append(a)
        self.add.append(self.add[-1])
        self.mul.append(self.mul[-1])

    def addAll(self, inc):
        self.add[-1] += inc

    def multAll(self, m):
        self.add[-1] = self.add[-1] * m % mod
        self.mul[-1] = self.mul[-1] * m % mod

    def getIndex(self, i):
        if i >= len(self.A): return -1
        m = self.mul[-1] * pow(self.mul[i], mod - 2, mod) 
        inc = self.add[-1] - self.add[i] * m
        return (self.A[i] * m + inc) % mod

# Your Fancy object will be instantiated and called as such:
# obj = Fancy()
# obj.append(val)
# obj.addAll(inc)
# obj.multAll(m)
# param_4 = obj.getIndex(idx)