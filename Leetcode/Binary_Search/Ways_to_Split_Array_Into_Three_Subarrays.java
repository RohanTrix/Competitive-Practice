/*
    IDEA : Great problem for Prefix Sum and Binary Search

           Lets define leftSum, midSum and rightSum as the sums of 3 portions. Firstly since this is a
           subarray sum type problem, Prefix Sum is necessary.

           Refer Image : https://assets.leetcode.com/users/images/9ca8c136-7c3d-4e6c-ad2a-3f9090c26053_1609657205.8195658.png
           
           We can get each leftSum in O(n) time iteratively. But for the midSum and leftSum, we need to
           find the possible places where partition can be done so as to keep both the conditions satisfied.
           The two conditions are...that midSum should be larger than leftSum and the other condition is midSum<=rightSum.

           Now, we know that the array has only positive integers. So, binary search on the prefix sum array
           and find out the 2 boundaries satisfying these conditions. However, we need to Binary Search
           for both conditions separately. Since it is possible that the 2 points for these conditions actually
           cross each other(we will skip counting when that happens).

*/

public class Ways_to_Split_Array_Into_Three_Subarrays
{
    public int searchLeftInd(int pref[], int start, int leftSum)
    {
        int n = pref.length-1;
        int left = start, right = n-1;
        int ans = -1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(pref[mid] - pref[start-1] >=leftSum)
            {
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
    public int searchRightInd(int pref[], int start)
    {
        int n = pref.length-1;
        int left = start, right = n-1;
        // System.out.println(left+" "+right);
        int ans = -1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int rightSum = pref[n] - pref[mid];
            int midSum = pref[mid] - pref[start-1];
            if(midSum<=rightSum)
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return ans;
    }
    public int[] prefixSum(int nums[])
    {
        int pref[] = new int[nums.length+1];
        for(int i = 1; i<=nums.length; i++)
            pref[i]+=pref[i-1]+nums[i-1];
        return pref;
    }
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int pref[] = prefixSum(nums);
        long cnt = 0;
        int mod = (int)1e9+7;
        for(int start = 1; start<n-1; start++)
        {
            int leftSum = pref[start];
            int leftInd = searchLeftInd(pref, start+1,leftSum);
            int rightInd = searchRightInd(pref, start+1);
            // System.out.println(leftInd + " " + rightInd);
            if( leftInd>rightInd || leftInd==-1 || rightInd==-1) continue;
            cnt+=(rightInd-leftInd+1);
            cnt%=mod;
        }
        return (int) cnt;
    }
}