class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        d1 = {}
        d2 = {}
        for i in word1:
            if i not in d1.keys():
                d1[i] = 1
            else:
                d1[i]+=1
        for i in word2:
            if i not in d2.keys():
                d2[i] = 1
            else:
                d2[i]+=1
        l1 = sorted(d1.values())
        l2 = sorted(d2.values())
        #print(l1,l2)
        if l1!=l2:
            return False
        if sorted(d1.keys()) != sorted(d2.keys()):
            return False
        return True