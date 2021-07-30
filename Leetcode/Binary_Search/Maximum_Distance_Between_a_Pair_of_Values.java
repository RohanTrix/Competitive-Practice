package Leetcode.Binary_Search;

class Maximum_Distance_Between_a_Pair_of_Values {
    // MY SOLUTION : 
    // https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/discuss/1198795/Java-Binary-Search-O(len2-*-log(len1))
    public boolean possible(int val1,int val2)
    {
        return val1<=val2;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int bestans=0, finalans = 0;
        for( int j = 0 ;j<nums2.length;j++)
        {

            int l = 0;
            int r = j;
            bestans = 0;
            r = Math.min(r, nums1.length-1);
            while(l<=r)
            {
                int mid = l + (r-l)/2;
                if(possible(nums1[mid],nums2[j]))
                {
                    bestans = j-mid;
                    r = mid-1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            finalans = Math.max(bestans, finalans);
        }
        return finalans;
    }
}