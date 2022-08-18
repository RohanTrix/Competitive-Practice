    # Sorting by ages will give us ordering of age. Now, since the constraints are low, we can go for DP.
    # At every player, we have 2 chocies : Take or Not Take....Not take option is quite simple. However, for Take,
    # we need to make sure that the score of the person we take right now is >= to the max score uptil now. Checking this will
    # suffice since we have already sorted by ages..and hence the current player we are taking will have an age MORE THAN OR EQUAL
    # to current age


class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        ages, scores = zip(*sorted(zip(ages, scores)))
        dp = list(scores)

        for i in range(len(scores)):
            for j in range(i):
                if scores[i] >= scores[j]:
                    dp[i] = max(dp[i], scores[i] + dp[j])
        return max(dp)
    
        # Top Down shows MLE for some reason
        """
        @cache
        def bestTeam(i, maxScore):
            if i == n: return 0
            
            ch1 = bestTeam(i+1, maxScore)
            ch2 = -inf
            if people[i][1]>=maxScore:
                ch2 = bestTeam(i+1, people[i][1]) + people[i][1]
            
            return max(ch1, ch2)
        
        return bestTeam(0, 0)
        """