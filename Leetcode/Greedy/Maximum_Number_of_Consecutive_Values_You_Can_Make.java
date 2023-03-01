import java.util.Arrays;

/**
 *         V.TRICKY LOGIC ----- EASY IMPLEMENTATION
 *         LOGIC : https://assets.leetcode.com/users/images/f1280227-dec4-4514-ab56-e68b15b5bf7b_1616257807.8662581.png
 *         
 *         The only case when we cannot extent without leaving any gaps in the consecutive no. is the following
 * 
 *                  |----------|
 *                  0    i
 *                                 x
 *                             |------------------------------|
 * 
 *         In this case, the current value x (say jump value) is greater than the size of (i+1)...meaning that if we jump 0 --> 0+x --> x (x will be greater than i+1)
 */

public class Maximum_Number_of_Consecutive_Values_You_Can_Make {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int sum = 0;
        for(int num : coins) {
            if(num>sum+1) break;
            sum+=num;
        }
        return sum+1;
    }
}