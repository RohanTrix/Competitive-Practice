# Sort each string...and add to the list of its corresponding key
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = Counter()
        for s in strs:
            ss = "".join(sorted(s))
            if ss not in d:
                d[ss] = []
            d[ss].append(s)
        
        res = []
        for s in d.values():
            res.append(s)
        
        return res