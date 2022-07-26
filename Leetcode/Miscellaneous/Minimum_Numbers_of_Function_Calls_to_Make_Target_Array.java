/**
 *      IDEA : 
 *             Observations:
 *                  1) For every non-zero number, we need 1 or more operations
 *                  2) Since the multiply operation multiplies all elements by 2...we can mentally
 *                     reorder these operations between the +1 operations. The reason for doing that is
 *                     that to reach the highest power of 2 using x2 operation for a particular no.
 *                     can also be used to reach lower powers of 2. So basically the MAX power of 2
 *                     will be required
 * 
 *                  3) For a num with binary such as 10010...2 operations are need to introduce
 *                     2 set bits in the number..and then x2 operations can be used to set their positions
 *                     since x2 is essentially a left shift operation
 */

public class Minimum_Numbers_of_Function_Calls_to_Make_Target_Array {
    public int minOperations(int[] nums) {
        int ops = 0;
        int maxi = 0;
        for(int num : nums)
        {
            if(num == 0) continue;
            // Finds the number of 0's after the highest pow of 2...since that amout
            maxi = Math.max(maxi,Integer.numberOfTrailingZeros(Integer.highestOneBit(num)));
            ops+=Integer.bitCount(num);
        }
        return ops + maxi;
    }
}
