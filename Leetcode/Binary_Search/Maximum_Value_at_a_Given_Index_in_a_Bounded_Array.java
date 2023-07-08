/*
 *      IDEA : Binary Search needs to be done on the maxNum to place at index.
 *             The tricky part is how to check the possible function since n can be 1e9(so cannot make a looping logic).
 *             The idea here is to start placing numbers in decreasing order from limit until either we cannot place
 *             or we reach num=1(since we cannot go negative, we have to fill the remainig slots with 1) 
 * 
 */

public class Maximum_Value_at_a_Given_Index_in_a_Bounded_Array {
    public boolean possible(long limit, int n, int index, int maxSum) {
        //leftSlots and rightSlots are the number of cells where items are to be placed
        long leftSlots = index, rightSlots = n - leftSlots - 1;
        maxSum-=limit; // Limit is placed first at index so we remove that amount from teh maxSum
        limit--; // Now we wanna place in decreasing order from limit-1

        long leftSum = 0, rightSum = 0;
        if(leftSlots>=limit) {// Case 1: Slots remain after pladcing elements in decreasing ordr, hence we fill remaining slots with 1s
            leftSum+=(limit*(limit+1))/2;
            leftSum+=leftSlots-limit;
        }
        else { // Case 2: We place as many as we can...and hence subtract the nums that are outside the array
            long limitOutOfLeftSlots = limit - leftSlots;
            leftSum+=(limit*(limit+1))/2 - (limitOutOfLeftSlots * (limitOutOfLeftSlots+1))/2;
        }
        if(rightSlots>=limit) {
            rightSum+=(limit*(limit+1))/2;
            rightSum+=rightSlots-limit;
        }
        else {
            long limitOutOfRightSlots = limit - rightSlots;
            rightSum+=(limit*(limit+1))/2 - (limitOutOfRightSlots * (limitOutOfRightSlots+1))/2;
        }
        return leftSum+rightSum<=maxSum;
    }
    public int maxValue(int n, int index, int maxSum) {
        long l = 1, r = maxSum;
        long ans = -1;
        while(l<=r) {
            long mid = l + (r-l)/2;
            if(possible(mid, n, index, maxSum)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return (int)ans;
    }
}
