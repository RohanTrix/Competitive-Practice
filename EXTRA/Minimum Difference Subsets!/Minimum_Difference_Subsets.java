import java.util.stream.*;
public class Solution {
    public int solve(int[] A) {
        int sum =0, n = A.length;
        int s = 0;
        sum = IntStream.of(A).sum();
        s = sum/2;
        boolean dp[][] = new boolean[n+1][s+1];
        for(int currNum=0;currNum<=n;currNum++)
        {
            for(int currSum=0; currSum<=s; currSum++)
            {
                if(currNum==0){
                    dp[currNum][currSum] = false;
                    continue;
                }
                    
                if(currSum==0){
                    dp[currNum][currSum] = true;
                    continue;
                }
                
                
                dp[currNum][currSum] = dp[currNum-1][currSum];
                if(A[currNum-1]<=currSum)
                    dp[currNum][currSum] = dp[currNum][currSum] || dp[currNum-1][currSum-A[currNum-1]];
            }
        }
        for(int i=s;i>=0;i--)
        {
            if(dp[n][i])
                return sum - (2*i);
        }
        return sum;
    }
}
