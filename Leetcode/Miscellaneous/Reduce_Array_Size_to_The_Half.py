class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        d = {}
        for i in arr:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i]+=1
        
        print(list(d.keys()), flush = True)
        l = sorted(list(d.keys()),key = lambda x: d[x], reverse = True)
        s = 0
        i = 0
        while(s<len(arr)//2):
            s+=d[l[i]]
            i+=1
        return i