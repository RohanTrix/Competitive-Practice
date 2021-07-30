package Leetcode.DP;

import java.util.*;
class Video_Stitching {
    public int videoStitching(int[][] clips, int time) {
        
        Arrays.sort(clips, (x,y) -> Integer.compare(x[0], y[0])); // Sorting based on start time
        
        int dp[] = new int[101]; // dp[i] => Min intervals needed to cover till ith time
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        
        dp[0] = 0; // At T=0, we do not need any intervals
        
        for(int c[] : clips)
        {
            int start = c[0];
            
            if(start>=time) break;
            
            int end = c[1];
            for(int i = start; i<=end;i++)
            {
                dp[i] = Math.min(dp[i], dp[start] + 1);
            }
            
        }
        
        return (dp[time]==Integer.MAX_VALUE-1)?-1:dp[time];
        
        }
}