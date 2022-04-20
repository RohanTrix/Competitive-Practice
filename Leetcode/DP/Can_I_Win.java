
// IDEA : Simple Game Theory DP. One IMP observation is that we do not need to store the running sum,
//        since that can be uniquely determined from the mask itself. Order of coice of elements do not matter,
//        only the numbers chosen matter.

class Solution {
    int TOTAL;
    int MAX_CHOICE;
    Boolean dp[][]; // dp[mask][player]
    
    public boolean winner(int currSum, int mask, int p)
    {
        if(currSum >= TOTAL) return p==0?false:true;
        if(dp[mask][p]!=null) return dp[mask][p];
        boolean ans;
        if(p == 0)
        {
            ans = false;
            for(int i = 0; i<MAX_CHOICE; i++)
            {
                if((mask&(1<<i))==0)
                {
                    ans = ans || winner(currSum+i+1,mask|(1<<i), 1);
                    if(ans) break;
                }
            }
            
        }
        else
        {
            ans = true;
            for(int i = 0; i<MAX_CHOICE; i++)
            {
                if((mask&(1<<i))==0)
                {
                    ans = ans && winner(currSum+i+1,mask|(1<<i), 0);
                    if(!ans) break;
                }
            }
        }
        
        return dp[mask][p] = ans; 
    }
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        TOTAL = desiredTotal;
        MAX_CHOICE = maxChoosableInteger;
        int mask = 1<<(maxChoosableInteger);
        dp = new Boolean[mask][2];
        int fullSum = maxChoosableInteger*(maxChoosableInteger+1)/2;
        if( fullSum < desiredTotal) return false;
        if(desiredTotal==0 ) return true;
        boolean ans = winner(0,0,0);
        
        return ans;
    }
}