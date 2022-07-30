/**
 * WATCH : ALEX WICE INTERVIEW WEEKLY - 13
 * IDEA : Consider each A[..i] that is monotone increasing, and say we remove
 *        some subarray A[i+1..j-1]. To remove the least, we want the lowest j such
 *        that A[i] <= A[j] and A[j..] is monotone increasing. Let's call this j =
 *        opt(i).
 * 
 *        Our algorithm is this: first, find the lowest j so that A[j:] is monotone
 *        increasing. Then, for each i such that A[..i] is monotone increasing, update
 *        j to be the lowest j >= j_old with A[i] <= A[j]. It is guaranteed A[j:] is
 *        monotone increasing from our original setup, so j = opt(i).
 */
public class Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {
    public int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        int j = n - 1;

        // j is the lowest index such that A[j...] is monotone increasing
        while (j > 0 && nums[j] >= nums[j - 1])
            j--;
        int mini = j;

        for (int i = 0; i < j; i++) {
            // If nums[0...i] is no longer increasing, then we should stop
            if (i > 0 && nums[i] < nums[i - 1])
                break;

            // Finding the first j such that A[i] <= A[j-1]....Also, this j is a suffix of the j we originally set,
            // it is by default a monotonic increasing seq.
            while (j < n && nums[i] > nums[j])
                j++;
            
            // Count elements from [i+1..j-1]
            mini = Math.min(mini, j - i - 1);

        }
        return mini;
    }
}