import java.util.stream.*;
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int dp[] = new int[n];
        if(n<3) return 0;
        Arrays.fill(dp,0);
        for(int i =2;i<n;++i)
        {
            if(A[i]-A[i-1]==A[i-1]-A[i-2])
            {
                dp[i]=dp[i-1]+1;
            }
            else
                dp[i] = 0;
        }
       return IntStream.of(dp).sum();
        
    }
}