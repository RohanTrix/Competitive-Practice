package Leetcode.Miscellaneous;

import java.util.ArrayList;
import java.util.List;
/**
 *      IDEA : First important thing to check is how many operations can we perform and that the elements
 *             are a permutation(unique values). By applying the logic below, we will always
 *             apply 2*arr.length ops and hence will be below the limit
 * 
 *             Now, we need to observe 2 things here:
 *                  1) The length of the prefix...the endpoint...can be chosen by us
 *                  2) While reversing the array, using the above point, we can fix the position for a certain element
 * 
 *             So to fix a element in its place, we first find its position in the array, then reverse the array uptil that pos so that
 *             this element comes to the 0th position...and then again reverse the array uptil the desired pos so that
 *             the element at the beginning gets its desired pos.
 *              
 *             One last thing to take care of is to do these for elements in reverse order, since after fixing a position,
 *             we don't want that element to get displaced due to other's ops.
 *             
 * 
 */



public class Pancake_Sorting {
    public void reverse(int nums[], int n) {

        for(int i = 0; i<n/2; i++) {
            int t = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = t;
        }
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int num = n; num>0; num--) {
            int idx = -1;
            for(int j = 0; j<n; j++) if(arr[j] == num) idx = j;
            res.add(idx+1);
            reverse(arr, idx+1);

            res.add(num);
            reverse(arr, num);

        }
        return res;
    }
}
