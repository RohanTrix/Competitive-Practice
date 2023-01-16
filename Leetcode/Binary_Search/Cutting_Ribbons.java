package Leetcode.Binary_Search;

import java.util.Arrays;

/**
 * IDEA : If we are able to cut the ribbons such that we can make ribbons of length x with cnt>=k,
 *        then surely we could have made as many or more cuts with a ribbon length <x. Hence this gives us a binary searchable property.
 *        
 *        `num/mid` gives us the cnt of ribbons of length `mid` that we can get from `num` sized ribbons.
 */


public class Cutting_Ribbons {
    // Solved on binarysearch.com -> https://binarysearch.com/room/Badge-first-search-3xSuonykQL?questionsetIndex=2
    public boolean possible(int mid, int ribbons[],int k)
    {
        int cnt = 0;
        for(int num : ribbons)
        {
            cnt+=num/mid;
        }
        return cnt>=k;
    }
    public int solve(int[] ribbons, int k) {
        int maxi = 0;
        Arrays.sort(ribbons);
        for(int num : ribbons) maxi = Math.max(maxi, num);
        int left = 1, right = maxi;
        int ans = -1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(possible(mid, ribbons, k))
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return ans;
    }
}
