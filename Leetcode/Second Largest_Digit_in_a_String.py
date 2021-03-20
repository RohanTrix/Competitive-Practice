class Solution:
    def secondHighest(self, s: str) -> int:
        maxi = -1
        for i in s:
            if i in "1234567890":
                maxi = max(int(i),maxi)
        #print(maxi)
        maxi2 = -1
        for i in s:
            if i in "1234567890" and int(i)<maxi:
                maxi2 = max(maxi2, int(i))
        print(maxi2)
        return maxi2