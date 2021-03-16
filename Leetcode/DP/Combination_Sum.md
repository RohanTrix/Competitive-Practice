# Both Solutions important
### Java Solution (Backtracing)
```java

//https://www.youtube.com/watch?v=2_58CA1fyn4

class Solution {
    private void backtrack(int cand[],
                           int startIndex,
                            int target,
                             List<Integer> currList,
                             List<List<Integer>> result)
        //cand[] is the candidates array
        //startIndex is the starting Index we need to start from in the cand[]
        //currList is the currList being formed in the backtracking tree
        //result stores the list of all such valid currLists.
        
    {
        if(target<0)
            return;
        if(target == 0)
        {
            result.add(new ArrayList(currList));
            return;
        }
        for(int i = startIndex; i< cand.length; i++)
        {
            currList.add(cand[i]);
            backtrack(cand,i,target-cand[i],currList, result);
            currList.remove(currList.size() -1);
        }
        
    }
    public List<List<Integer>> combinationSum(int candidates[], int target) {
        
        List<List<Integer>> result = new ArrayList();
        backtrack(candidates, 0, target, new ArrayList(),result);
        return result;
    }
}

```
### Python Solution (DP)
```python

# https://www.youtube.com/watch?v=2_58CA1fyn4
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        dp = [[] for _ in range(target+1)]
        
        for c in candidates:
            for t in range(1, target+1):
                if c>t:
                    continue
                if c==t:
                    dp[t].append([c])
                    continue
                
                for l in dp[t-c]:
                    dp[t].append([c]+l)
        return dp[t]
```
