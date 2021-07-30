package Leetcode.Binary_Search;
import java.util.stream.*;

public class Minimum_Limit_of_Balls_in_a_Bag {
    // REFER - https://youtu.be/znZ4wT1L8Y0
    public boolean possible(int[] nums, int maxBall, int maxOp)
    {
        int ops = 0;
        for(int n : nums)
        {
            if(n%maxBall == 0)
                ops+=(n/maxBall) - 1;
            else
                ops+=(n/maxBall);     
        }
        return ops<=maxOp;
    }
    public int minimumSize(int[] nums, int maxOp) {
        int left = 1, right = IntStream.of(nums).max().getAsInt();
        int bestAns = 0;
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            if(possible(nums, mid, maxOp))
            {
                bestAns = mid;
                right = mid-1;
            }
            else
                left = mid + 1;
        }
        return bestAns;
    }
}
