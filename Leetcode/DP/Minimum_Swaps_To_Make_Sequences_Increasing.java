/*
        IDEA : Explained in Onenote
*/
public class Minimum_Swaps_To_Make_Sequences_Increasing
{
    public int dp[][];
    int nums1[], nums2[];
    int INTMAX = Integer.MAX_VALUE;
    public int minMoves(int i, int swap)
    {
        if(i==0) return swap==0?0:1;
        
        if(dp[i][swap]!=-1) return dp[i][swap];
        
        int a = INTMAX, b = INTMAX;
        if(swap==0)
        {
            
            if(nums1[i]>nums1[i-1] && nums2[i] > nums2[i-1])
                a = minMoves(i-1,0);
            if(nums1[i]>nums2[i-1] && nums2[i] > nums1[i-1])
                b = minMoves(i-1,1);
            return dp[i][swap] = Math.min(a,b);
        }
        else
        {
            if(nums1[i]>nums2[i-1] && nums2[i] > nums1[i-1])
                a = minMoves(i-1,0);
            if(nums1[i]>nums1[i-1] && nums2[i] > nums2[i-1])
                b = minMoves(i-1,1);
            return dp[i][swap] = 1 + Math.min(a,b);
        }
        
    }
    public int minSwap(int[] n1, int[] n2) {
        nums1 = n1;
        nums2 = n2;
        dp = new int[n1.length][2];
        for(int a[]:dp) Arrays.fill(a,-1);
        
        return Math.min(minMoves(nums1.length-1,0), minMoves(nums1.length-1, 1));
    }
}