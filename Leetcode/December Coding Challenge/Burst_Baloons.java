/* IDEA: The problem uses a special DP technique. If we think naively,
         we might consider taking an element i, bursting it and then solving the
         left and right partitions. However, this approach doesnt work as

            1) bursting rightmost element of left partition doesnt have contact with its right boundary
            2) bursting leftmost element  of right partition doesnt have contact with its left boundary
        
        
            CORRECT TECHNIQUE:

            DP STATE: 

                dp[l][r] = MAX Score we get bursting balloons in the range nums[l...r]

            DP TRANSITION:

                Instead of thinking which element to burst first, we think which to burst last.
                If we fix some kth element to burst, we know its score will be nums[l-1]*nums[k]*nums[r+1].
                This score will be added to the score gained by 
                    1) bursting nums[l...k-1] 
                    2) bursting nums[k+1...r]
                
            So finally,

                left_bound = nums[l-1] if exists else 1
                right_bound = nums[r+1] if exists else 1
                dp[l][r] = MAX(
                                for each element `last` that we shall burst at last in nums[l...r]:
                                    left_bound*nums[last]*right_bound
                                                +
                                          dp[l][last-1]
                                                +
                                          dp[last+1][r]
                                )

*/

public class Burst_Baloons
{
    int dp[][];
        int INTMIN = Integer.MIN_VALUE/2;
        public int maxScore(int l, int r, int nums[])
        {
            if(l>r) return 0;
            int left_bound = l-1>=0?nums[l-1]:1;
            int right_bound = r+1<nums.length?nums[r+1]:1;

            if(l==r) return left_bound*nums[l]*right_bound;
            if(dp[l][r]!=-1) return dp[l][r];

            int maxi = INTMIN;
            for(int last = l; last<=r; last++)
            {
                int lastScore = left_bound*nums[last]*right_bound;
                int leftofPartition = maxScore(l,last-1, nums);
                int rightofPartition = maxScore(last+1, r, nums);
                int ans = lastScore + leftofPartition + rightofPartition;

                maxi = Math.max(maxi, ans);
            }
            return dp[l][r] = maxi;
        }
        public int maxCoins(int[] nums) {
            int n = nums.length;
            dp = new int[n][n];
            for(int a[]:dp) Arrays.fill(a, -1);
            return maxScore(0, n-1, nums);

        }
}

class Burst_Baloons1 {
    //REVISE FROM TECH DOSE
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] iNums = new int[len+2];
        iNums[0] = 1;
        for(int i=0;i<len;i++){
            iNums[i+1]= nums[i];
        }
        iNums[len+1] =1;

        int[][] dp = new int[len+2][len+2];
        // TC O(n3) SC O(n2)
        for(int window=1;window<=len;window++){

            for(int left =1;left+ window < len+2;left++){
                int right = left + window -1;
                for(int i=left;i<=right;i++){
                    int currCost = iNums[left-1] * iNums[i] * iNums[right+1] + dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], currCost);
                }
            }
        }
        return dp[1][len];

    }
}