package Leetcode.Greedy;
// REFER : https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/discuss/754623/Detailed-Explanation
public class Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {
    public int minNumberOperations(int[] target) {
        int moves = target[0];
        
        for(int i=1; i<target.length; i++)
        {
            if(target[i]>=target[i-1])
            {
                moves+=target[i] - target[i-1];
            }
        }
        return moves;
    }
}
