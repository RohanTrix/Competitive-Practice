class Solution:
    def printVertically(self, s: str) -> List[str]:
        arr = s.split()
        maxi = len(max(arr, key= lambda x: len(x)))
        
        narr = []
        for ss in arr:
            spaces = " "*(maxi-len(ss))
            ss+=spaces
            narr.append(ss)
        
        finarr = []
        for i in range(maxi):
            tmp = ""
            for j in narr:
                tmp+=j[i]
            tmp = tmp.rstrip()
            finarr.append(tmp)
        return finarr