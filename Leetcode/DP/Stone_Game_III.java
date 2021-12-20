package Leetcode.DP;

/*      Idea:
            Its clearly a DP problem.
            DP STATE:
                dp[ind][p] = (Alice's score - Bob's Score) for stones[i...n] 
                when its p=0/1 player's turn

                Reason for storing difference: Since we don't care what the actual score of 
                Alice or Bob is, we only care about who is larger. Hence more negatives will indicate
                Bob is larger and more positive will indicate Alice is larger. 

                Example: A = 10, B = -2 ----> A - B  = 10 - (-2) = 12 which means A is 12 points ahead of B

            DP TRANSITION:
            if p==0:
            
            dp[ind][0] =  MAX(
                                dp[ind+1][1] + take1 ,
                                dp[ind+2][1] + take2 ,
                                dp[ind+3][1] + take3
                             )
            
            else:

            dp[ind][0] =  MIN(
                                dp[ind+1][0] - take1 ,
                                dp[ind+2][0] - take2 ,
                                dp[ind+3][0] - take3
                             )
            
            In Alice we are adding take1,take2 or take3 since the diff A - B has ALice of positive side
            In Bob we are subtracting take1, take2 or take3 since the diff A - B has Bob on the negative side          

*/
public class Stone_Game_III {
    class Solution {
        public int dp[][];
        int INT_MIN = Integer.MIN_VALUE/2;
        int INT_MAX = Integer.MAX_VALUE/2;
        public int maxSum(int stones[], int ind, int p)
        {
            if(ind==stones.length) return 0;
            if(dp[ind][p]!=INT_MIN) return dp[ind][p];
            
            // Get sum of 1, 2 and 3 stones if possible to be picked up from beginning
            int take1 = (ind+1<=stones.length)?stones[ind]:0;
            int take2 = (ind+2<=stones.length)?take1 + stones[ind+1]:0;
            int take3 = (ind+3<=stones.length)?take2 + stones[ind+2]:0;

            // Alice
            if(p==0)
            {
                // Get the difference from dp[ind+k][1] and add the take scores 
                take1 += (ind+1<=stones.length)?maxSum(stones,ind+1,1):INT_MIN;
                
                take2 += (ind+2<=stones.length)?maxSum(stones, ind+2,1):INT_MIN;
                
                take3 += (ind+3<=stones.length)?maxSum(stones, ind+3,1):INT_MIN;
                
                dp[ind][p] = Math.max(take1, Math.max(take2, take3)); // Alice wants to maximise the diff so that its in her favour
            }
            //Bob
            else
            {
                 // Get the difference from dp[ind+k][1] and subtract the scores 
                take1 = -take1;
                take1 += (ind+1<=stones.length)?maxSum(stones,ind+1,0):INT_MAX;
                take2 = -take2;
                take2 += (ind+2<=stones.length)?maxSum(stones, ind+2,0):INT_MAX;
                take3 = -take3;
                take3 += (ind+3<=stones.length)?maxSum(stones, ind+3,0):INT_MAX;
                
                dp[ind][p] = Math.min(take1, Math.min(take2, take3)); // Bob wants to minimise the diff so that its in his favour
            }
    
            return dp[ind][p]; // return DP value
            
        }
            
        public String stoneGameIII(int[] stoneValue) {
            
            //System.out.println(Arrays.toString(stoneValue));
            dp = new int[stoneValue.length][2];
            for(int a[]:dp) Arrays.fill(a, INT_MIN);
            
            int res = maxSum(stoneValue,0,0);
            if(res==0)return "Tie";
            return res>0?"Alice":"Bob";
        }
    }
}
