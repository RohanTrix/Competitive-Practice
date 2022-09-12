package Leetcode.TwoPointers;

/**
 *      IDEA : Lets say I can lose t1 tokens or t2 tokens (t1 < t2)....since I get same amount of
 *             score increase in both the cases, I would obviously want to save my tokens as much as possible
 *             (greedy)...so I will remove t1...
 * 
 *             Similarly, by losing 1 point...I can either gain t1 or t2( t1 < t2) tokens...greedily,
 *             I would want more no. of tokens for the same loss in score...So I will take t2
 * 
 * 
 *             Thus, the final idea is...we sort the array to get an ordering between the tokens,
 *             we use a 2 pointer approach...and simulate the above idea. Follow code for more understanding
 */

public class Bag_of_Tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, currPower = 0, n = tokens.length;
        int left = 0, right = n-1;
        while(left<=right)
        {
            if(power >= tokens[left]) 
            {
                score++;
                power-=tokens[left++];// Losing least no. of tokens as we can for same increase in score
            }
            else if(score > 0 && left<right)
            {
                score--;
                power+=tokens[right--]; // Gaining as many tokens as we can for the same loss in score
            }
            else break;
        }
        return score;
    }
}
