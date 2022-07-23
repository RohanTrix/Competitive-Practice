import imp


class Solution:
    def minDays(self, n: int) -> int:
        # Eat 2n/3 means we are left with (n - 2*n/3) = n/3
        # We cannot do BFS and it is linear and n<=10**9...the move of Eating ONE orange
        # is the one that could cause TLE.
        # If we observe....its obviously better to divide by 2 or 3 (when we can) that to decrease by 1.
        # And when we cannot...only move we have is "Eat One Orange"..so we do that

        # So the idea is....lets say to make a n/3 move..to find number of "Eat one Orange" moves..
        # to bring it down to the closest multiple of 3....this is simply n%3...similar case to make divisible
        # by 2...And now...we want minimum steps....so we do a MIN of the 2 transitions

        from functools import lru_cache
        @lru_cache(None)
        def minMoves(n):
            if n <=1:
                return n
            
            return min(
                n%3 + 1 + minMoves(n//3), # (n%3) is moves to bring it down to multiple of 3, + 1 is for eating 2*n/3 oranges
                n%2 + 1 + minMoves(n//2), # (n%2) is moves to bring it down to multiple of 2, + 1 is for eating n/2 oranges
            )
        
        return minMoves(n)