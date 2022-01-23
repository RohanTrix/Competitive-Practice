public class Maximum_Length_of_Subarray_With_Positive_Product
{
    // Check OneNote
    Integer dp[][];
    public int maxLength(int i, int sign, int nums[])
    {
        if(i==0)
        {
            // If first element is +ve and we need +ve product, ans = 1
            if(nums[i]>0&&sign==0)
                return dp[i][0] = 1;
            // If first element is -ve and we need +ve product, ans = 1
            if(nums[i]<0&&sign==1)
                return dp[i][1] = 1;
            
            // We cannot make the desired product(Example : You need sign = 0 but first number is negative)
            // Denoting -1 to show not possible
            else
                return dp[i][sign] = -1;
        }
        // A positive or negative product subarray cannot contain 0, hence if zero come,
        // it can form neither of the arrays
        if(nums[i] == 0) return dp[i][sign] = -1;
        if(dp[i][sign]!=null) return dp[i][sign];

        
        int poslen = maxLength(i-1,0, nums); // Longest length of subarray ending at (i-1) with +ve product
        int neglen = maxLength(i-1, 1, nums);// Longest length of subarray ending at (i-1) with -ve product
        // If we need to make positive sum for subarray ending at i
        if(sign==0)
        {

            // We want to make current prod +ve

            // If current number is +ve, then we can extend the poslen length
            // only if there is a positive prod subarray ending at previous index is possible. If not,
            // we have to start the positive subarray from current index

            // If current number is ive, then we can extend the poslen length
            // only if there is a positive prod subarray ending at previous index is possible. If not,
            // we have to start the positive subarray from current index

            if(nums[i]>0)
            {
                return dp[i][0] = poslen==-1?1:poslen+1;
            }
            else
            { 
                return dp[i][0] = neglen==-1?-1:neglen+1;
            }   
        }
        else
        {
            //Want to make curr pord negative
            
            if(nums[i]>0)
            {
                return dp[i][1] = neglen==-1?-1:neglen+1;
            }
            else
            {
                return dp[i][1] = poslen==-1?1:poslen+1;
            }
        }
    }
    public int getMaxLen(int[] nums) {
        dp = new Integer[nums.length][2];
        int len = 0;
        for(int i = 0;i<nums.length; i++)
            len = Math.max(len,maxLength(i,0,nums));
        return len;
    }
}