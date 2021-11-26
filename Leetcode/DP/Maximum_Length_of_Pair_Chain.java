package Leetcode.DP;

import java.util.stream.*;
public class Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        int len = pairs.length;
        int dp[] = new int[len];
        Arrays.fill(dp,1);
        for(int i = 1; i<len;i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(pairs[i][0] > pairs[j][1])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return IntStream.of(dp).max().getAsInt(); 
    } 
}
