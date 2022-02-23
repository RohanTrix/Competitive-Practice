/*
        IDEA : We can clearly use DP here since s[0...i-1]'s cost will be used to calculate s[0...i]

        DP STATE : 
            We want to either end the current string s[0...i] with As or with Bs.
            So we store answer for both denoted by lastChar(0 means A, 1 means B).

            So...dp[i][0] = Cost to convert s[0...i] to end with A
                 dp[i][1] = Cost to convert s[0...i] to end with B

        DP TRANSITION:
            If we want to end our string with A, we need to make sure everything before was made 
            into a secquence of AAAAAAAA only.
                
                dp[i][0] = cost to end s[0...i-1] with 'a' --> dp[i-1][0]  
                                                    +
                                  if s[i] =='a', we are good, otherwise we need + 1 cost to remove it
                
            
            If we want to end our string with B, we need to make everything before either end with AAAA
            or end with BBBB.

                dp[i][1] = cost to end s[0...i-1] with 'b' --> dp[i-1][1]
                                                    +
                            if s[i] == 'b', we are good, otherwise we need +1 to remove it

*/
public class Minimum_Deletions_to_Make_String_Balanced {
    int dp[][];
    String s;
    public int minCost(int i,int lastChar)
    {
        if(i == 0)
        {
            if((s.charAt(0) == 'a' && lastChar==0) ||(s.charAt(0) == 'b' && lastChar==1)) return 0;
            return 1;
        }
        if(dp[i][lastChar]!=-1) return dp[i][lastChar];
        
        if(lastChar == 0)
        {
            return dp[i][lastChar] = minCost(i-1,0) + ((s.charAt(i) == 'a')?0:1);
        }
        else
        {
            return dp[i][lastChar] = Math.min(minCost(i-1,1), minCost(i-1,0)) +((s.charAt(i) == 'a')?1:0) ;
        }
    }
    
    public int minimumDeletions(String str) {
        s = str;
        dp = new int[str.length()][2];
        for(int a[] : dp) Arrays.fill(a,-1);
        int n = s.length();
        int ans = Math.min(minCost(n-1,0), minCost(n-1,1));
        // for(int a[]: dp) System.out.println(Arrays.toString(a));
        return ans;
    }
}
