/**
 * IDEA : Just calculate the max (counts of prev continuous Ones + after continuos Ones)
 *        for each zero element.
 *        Corner case : All 1s then ans = n-1
 */

public class Longest_Subarray_of_1_s_After_Deleting_One_Element {
    int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int prev = 0;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 0) {prev = 0;continue;}
            left[i] = prev+1;
            prev = left[i];
        }
        prev = 0;
        for(int i = n-1; i>=0; i--)
        {
            if(nums[i] == 0) {prev = 0;continue;}
            right[i] = prev+1;
            prev = right[i];
        }
        int maxi = -1;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                if(i == 0) maxi = Math.max(maxi, right[i+1]);
                else if(i == n-1) maxi = Math.max(maxi, left[i-1]);
                else maxi = Math.max(maxi, left[i-1]+right[i+1]);
            }
        }
        return maxi==-1?n-1:maxi;
    }
}
