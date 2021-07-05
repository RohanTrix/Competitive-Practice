package Leetcode.Greedy;
import java.util.*;

class Solution {
    // REFER : https://www.youtube.com/watch?v=Gg64QXc9K0s
    // After intuition from above video, follow below solution
    
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (x,y) -> x[0]-y[0]); //Sorting based on start time
        
        int n = clips.length;
        
        int num = 0; // Final answer
        
        int maxTillNow = 0; // Finding the max we can reach currently
        
        int lastMax = 0; // The last max we reached, we need to find a                                    //maxTillNow larger than lastMax everytime
        
        while(lastMax < T) // Loop until we have found lastMax>=T
        {
            // Looping for each video clip
            for(int i = 0; i<n; ++i)
            {
                int start = clips[i][0];
                int end = clips[i][1];
                
                // In this for loop, we are finding the best clip which starts on or before the lastMax and takes us farther than the lastMax. If this happens, we keep the MAX(prev such max found, curr element's end).
                
                // Suppose we have [0 ---- 2]
                //                 [0 ---- 3]
                // In this we shud choose only [0 ---- 3] and thus we only update num(our final ans) after we have looped thru all possibilities and kept the max.
                
                if( start <=lastMax && end> lastMax)
                {
                    maxTillNow = Math.max(maxTillNow, end);
                }   
            }
            num++; // As said ,we update num only after we have found the best clip
            if(lastMax==maxTillNow) return -1; // Just in case, the prev best and the latest best are same, means we could not improve or extend our time. Thus, we can say its not possible to get the right time.
            
            lastMax = maxTillNow; // Updating the current max time reached as lastMax
            
        }
        return num;
        
    }
}