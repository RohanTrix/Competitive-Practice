package Leetcode.Greedy;

import java.util.*;

class Minimum_Number_of_Arrows_to_Burst_Balloons
{
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));
        int ans = 1;
        int mini = Integer.MIN_VALUE, maxi = Integer.MAX_VALUE;
        for(int i = 0; i<points.length;++i)
        {
            int left = points[i][0];
            int right = points[i][1];
            if(mini<=left && maxi>=right)
            {
                mini = left; maxi = right;
            }
            else if(maxi>=left)
            {
                mini = left;
            }
            else
            {   ans++;
                mini = left; maxi = right;
            }
        }
        return ans;
    }
}