from collections import Counter
class Top_K_Frequent_Elements:
    # Refer any video
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        maxFreq = max(freq.values())
        d = {}
        boxes = [[] for i in range(maxFreq+1)]
        
        for i in freq.keys():
            boxes[freq[i]].append(i)
        
        res,cnt = [],0
        for f in range(maxFreq,0,-1):
            for i in boxes[f]:
                res.append(i)
                cnt+=1
                if cnt==k:
                    return res