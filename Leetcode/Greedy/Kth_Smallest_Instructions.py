'''
    IDEA : Firstly, it should be clear that the total no. of paths to reach destination can be
           found by simple combinatorics... basically if we have H horizontal moves and V vertical moves,
           then at (H+V) places, if we choose positions of either H or V (sinc the other will get auto fixed)
           then we have that many number of ways.

           We want to go lexicographically, but we cant brute force by generating all. It is important to
           revisit LC : Permutation Sequence to understand this approach more thoroughly.

           We first try to place an H at the current pos, then we see if our rank of the 
           desired permutation is after the LAST permutaiton formed by placing H at curr pos..
           if it is, then we basically place an V at current position....and remove the cnt
           of permutations from our rank. Else, we just place an H currently.


'''

class Solution:
    def kthSmallestPath(self, dest: List[int], k: int) -> str:
        from math import comb
        
        ans = []
        V = dest[0]
        H = dest[1]
        
        while H>0 or V>0:
            ways = comb(H - 1 + V, V) # Ways of choosing position for V( auto fixes position of H) after placing H at curr pos
            if k <= ways: # If the total no. of sequences by placing H currently is more than k,
                         # then our required sequence lies before the lexicographically last seq which would be formed with H at current pos
                ans.append('H')
                H-=1
            
            # Else, our answer lies after all permutations of placing H at current pos. Hence we place V and remove the
            # no. of ways that would have been formed by placing H at current pos
            else:
                ans.append('V')
                V-=1
                k-=ways
                
        return ''.join(ans)